package fresher.dxc.minifilesharing.controller;

import fresher.dxc.minifilesharing.model.User;
import fresher.dxc.minifilesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/") // , method = RequestMethod.GET public
	public ModelAndView landing() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("landing");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getAuthorities().toString().equals("[MEMBER]")) {
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName", user.getName());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities().toString());
		if (auth.getAuthorities().toString().contains("MEMBER") || auth.getAuthorities().toString().contains("ADMIN")) {
			modelAndView.setViewName("landing");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		ModelAndView modelAndViewAdmin = new ModelAndView();
		ModelAndView modelAndViewMember = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities().toString());
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		if (auth.getAuthorities().toString().equals("[ADMIN]")) {
			modelAndViewAdmin.setViewName("admin");
			return modelAndViewAdmin;
		} else if (auth.getAuthorities().toString().equals("[MEMBER]")) {
			modelAndViewMember.setViewName("member");
			return modelAndViewMember;
		}
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
			modelAndView.addObject("message", "User has been registered fail.");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("message", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if (null != user) {
			modelAndView.setViewName("admin");
			modelAndView.addObject("userId", user.getId());
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ModelAndView memberHome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.addObject("userName", user.getName());
		return modelAndView;
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}
}
