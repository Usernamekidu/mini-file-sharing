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
		modelAndView.setViewName("index");
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
			modelAndView.setViewName("index");
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
}
