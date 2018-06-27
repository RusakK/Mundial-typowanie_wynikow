package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.service.TyperDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class TyperController {

    private final TyperDataService typerDataService;

    public TyperController(TyperDataService typerDataService) {
        this.typerDataService = typerDataService;
    }
/*
    @GetMapping
    public String addTyperForm(Model model){
        model.addAttribute("savedTyper", new Typer());
        return "saved";
    }

    @PostMapping
    public String saveTyper(@ModelAttribute("savedTyper") Typer typerToBeSaved) {
        typerDataService.addTyper(typerToBeSaved);
        return "redirect:/saved";
    }*/

}
