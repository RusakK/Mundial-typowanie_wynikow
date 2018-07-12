package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.model.Match;
import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.service.MatchDataService;
import home.project.spring.typer_Mundial.service.TyperDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mundial")
public class TyperController {

    private final TyperDataService typerDataService;

    private final MatchDataService matchDataService;

    public TyperController(TyperDataService typerDataService, MatchDataService matchDataService) {
        this.typerDataService = typerDataService;
        this.matchDataService = matchDataService;
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
    public String prepareNewTyper(Model model) {
        model.addAttribute("newTyper", new Typer());
        model.addAttribute("match1", new Match());
        model.addAttribute("match2", new Match());
        model.addAttribute("match3", new Match());
        return "newTyper";
    }

    @PostMapping
    public String saveNewTyper(@ModelAttribute("newTyper") Typer newTyperToBeSave,
                               @ModelAttribute("match1") Match match1,
                               @ModelAttribute("match2") Match match2,
                               @ModelAttribute("match3") Match match3) {

        typerDataService.addTyper(newTyperToBeSave);

        match1.setName("mecz1");
        match2.setName("mecz2");
        match3.setName("mecz3");

        List<Match> list = new ArrayList<>();
        list.add(match1);
        list.add(match2);
        list.add(match3);

        list.forEach(match -> match.setTyper(newTyperToBeSave));
        list.forEach(match -> match.setDate(new Date()));
        matchDataService.addAllMatches(list);
        return "redirect:/mundial";
    }


}
