package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Match;
import home.project.spring.typer_Mundial.repository.MatchRepository;
import home.project.spring.typer_Mundial.repository.TyperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMatchDataService implements MatchDataService {

    private final MatchRepository matchRepository;
    private final TyperRepository typerRepository;


    public DefaultMatchDataService(MatchRepository matchRepository, TyperRepository typerRepository) {
        this.matchRepository = matchRepository;
        this.typerRepository = typerRepository;
    }


    @Override
    public Match addMatch(Match newMatch) {
        return matchRepository.save(newMatch);
    }

    @Override
    public void addAllMatches(List<Match> matches) {
        matchRepository.save(matches);
    }

    @Override
    public Optional<Match> loadMatchesByTyperId(Integer typerId) {
        return matchRepository.findByTyper(typerId);
    }


}
