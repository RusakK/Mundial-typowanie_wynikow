package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.model.Match;
import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.service.TyperDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/mundial")
public class TyperController {

    @Autowired
    private final TyperDataService typerDataService;

    public TyperController(TyperDataService typerDataService) {
        this.typerDataService = typerDataService;
    }


    @GetMapping
    public String showRanking(Model model) {
        System.out.println("Pokaz ranking");
        List<Typer> typers = typerDataService.loadAllTypers();
        typers.sort(Comparator.comparing(Typer::getPoints));
        model.addAttribute("allTypers", typers);
        return "mundial";
    }

    @GetMapping("/newTyper")
    public String prepareNewTyper(
            Model model) {
        System.out.println("Przygotowanie nowego typera");
        model.addAttribute("newTyper", new Typer());
        return "newTyper";
    }

    @PostMapping
    public String saveNewTyper(@ModelAttribute("newTyper") Typer newTyperToBeSave) {
        System.out.println("zapis do bazy");
        typerDataService.addTyper(newTyperToBeSave);
        System.out.println(newTyperToBeSave.getId());
        return "redirect:/mundial";
    }

    @GetMapping("/{typerId}/typowanie")
    public String typeMatches(
            @PathVariable("typerId") Integer typerId,
            Model model) {
        Typer typer = typerDataService.loadById(typerId);
        if (typer != null) {
            model.addAttribute("typer", typer);
        }
        model.addAttribute("typeMatch", new ArrayList<Match>());
        model.addAttribute("match", new Match());

        System.out.println("stworzenie listy i meczu");
        return "typowanie";
    }


}
