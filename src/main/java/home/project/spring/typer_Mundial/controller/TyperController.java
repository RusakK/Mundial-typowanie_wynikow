package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.service.TyperDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mundial")
public class TyperController {

    private final TyperDataService typerDataService;

    public TyperController(TyperDataService typerDataService) {
        this.typerDataService = typerDataService;
    }


    @RequestMapping
    public String showRanking(Model model) {
        System.out.println("Pokaz ranking");
        List<Typer> typers = typerDataService.loadAllTypers();
        model.addAttribute("allTypers", typers);
        return "mundial";
    }

    @GetMapping("/newTyper")
    public String prepareNewTyper(Model model) {
        System.out.println("Przygotowanie nowego typera");
        model.addAttribute("newTyper", new Typer());
        return "newTyper";
    }

    @GetMapping("/{typerId}/typowanie")
    public String typeMatches(
            @PathVariable("typerId") Integer typerId,
            Model model) {
        model.addAttribute("typerId", typerId);
        return "typowanie";
    }

}
