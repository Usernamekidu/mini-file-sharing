package fresher.dxc.minifilesharing.controller;

import fresher.dxc.minifilesharing.messages.Message;
import fresher.dxc.minifilesharing.model.User;
import fresher.dxc.minifilesharing.service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public Page<User> getAll(Pageable pageable){
        return userService.getAll(pageable);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @RequestMapping(value="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(value="/getByEmail/{mail}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByEmail(@PathVariable String mail){
        System.out.println(mail);
        return userService.findUserByEmail(mail);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        System.out.println(user.getRoleList());
        userService.updateUser(user);
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public Message addUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}








