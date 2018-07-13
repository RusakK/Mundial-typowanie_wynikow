package home.project.spring.typer_Mundial.controller;

import home.project.spring.typer_Mundial.model.Match;
import home.project.spring.typer_Mundial.model.NewTyperFormData;
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
        List<Typer> typers = typerDataService.loadAllTypers();
        typers.sort(Comparator.comparing(Typer::getPoints));
        model.addAttribute("allTypers", typers);
        return "mundial";
    }

    @GetMapping("/newTyper")
    public String prepareNewTyper(Model model) {
        NewTyperFormData newTyperFormData = new NewTyperFormData();
        model.addAttribute("newTyper", newTyperFormData);
        return "newTyper";
    }

    @PostMapping
    public String saveNewTyper(@ModelAttribute("newTyper")NewTyperFormData newTyperFormData) {

        Typer typer = new Typer();
        typer.setNickname(newTyperFormData.getPreparingTyper().getNickname());
        typer.setEmail(newTyperFormData.getPreparingTyper().getEmail());
        typerDataService.addTyper(typer);


        Match match1 = new Match();
        match1.setName("match1");
        match1.setTyper(typer);
        match1.setDate(new Date());
        match1.setScoreTeamA(newTyperFormData.getMatch1().getScoreTeamA());
        match1.setScoreTeamB(newTyperFormData.getMatch1().getScoreTeamB());
        matchDataService.addMatch(match1);

        Match match2 = new Match();
        match2.setName("match2");
        match2.setTyper(typer);
        match2.setDate(new Date());
        match2.setScoreTeamA(newTyperFormData.getMatch2().getScoreTeamA());
        match2.setScoreTeamB(newTyperFormData.getMatch2().getScoreTeamB());
        matchDataService.addMatch(match2);

        Match match3 = new Match();
        match3.setName("match3");
        match3.setTyper(typer);
        match3.setDate(new Date());
        match3.setScoreTeamA(newTyperFormData.getMatch3().getScoreTeamA());
        match3.setScoreTeamB(newTyperFormData.getMatch3().getScoreTeamB());
        matchDataService.addMatch(match3);

        return "redirect:/mundial";
    }


}
