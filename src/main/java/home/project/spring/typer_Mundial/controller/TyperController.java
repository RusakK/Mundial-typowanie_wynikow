package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.service.TyperDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TyperController {

    private final TyperDataService typerDataService;

    public TyperController(TyperDataService typerDataService) {
        this.typerDataService = typerDataService;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String allTypers(Model model) {
        List<Typer> typers = typerDataService.loadAllTypers();
        model.addAttribute("allTypers", typers);
        model.addAttribute("typer", new Typer());
        return "showGames";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String saveTyper(Typer typer) {
        typerDataService.addTyper(typer);
        return "redirect:/show";
    }

}
