package tavluy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping(value = "/greeting")
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "qwer") String name, Model model){
        model.addAttribute("name", name);
        return "greeting.html";
    }
}
