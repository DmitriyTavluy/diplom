package tavluy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tavluy.model.Role;
import tavluy.model.User;
import tavluy.servise.CreateUserService;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/createuser")
@PreAuthorize("hasAuthority('ADMIN')")
public class CreateUserController {

    @Resource(name = "createUserService")
    private CreateUserService createUserService;

    @GetMapping
    public String userList(Map<String, Object> model){
        Iterable<User> users = createUserService.loadAllUsers();
        model.put("users", users);
        return "createuser";
    }

    @PostMapping
    public String addUser(@RequestParam String mail, @RequestParam String password,
                          @RequestParam String username, @RequestParam boolean active,
                          @RequestParam Set<Role> roles, Map<String, Object> model){
        User user = new User(username, password, mail, active, roles);
        createUserService.saveUsers(user);
        Iterable<User> users = createUserService.loadAllUsers();
        model.put("users", users);
        return "createuser";
    }
}
