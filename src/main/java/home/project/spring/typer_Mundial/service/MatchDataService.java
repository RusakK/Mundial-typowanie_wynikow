package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Match;

import java.util.Optional;

public interface MatchDataService {

    Match addMatch(Match newMatch);

    Optional<Match> loadMatchesByTyperId(Integer typerId);


}
