package tavluy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tavluy.model.Role;
import tavluy.model.User;
import tavluy.repo.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegisterController {


    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registrationUserInfo")
    public String registrationUserInfo() {
        return "registrationUserInfo";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addInfoAboutUser(User User, Map<String, Object> model) {

        User UserFromDB = userRepo.findByUsername(User.getUsername());

        if (UserFromDB != null) {
            model.put("message", "User with number or email already exist!" + User.getUsername());
            return "registrationUserInfo";
        }
        User.setActive(true);
        User.setRoles(Collections.singleton(Role.SPECIALIST));
        userRepo.save(User);
        return "redirect:/login";
    }

}
