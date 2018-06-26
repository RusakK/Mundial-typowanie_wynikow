package home.project.spring.typer_Mundial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/show")
    public String show(Model model){
        return "showGames";
    }
}
