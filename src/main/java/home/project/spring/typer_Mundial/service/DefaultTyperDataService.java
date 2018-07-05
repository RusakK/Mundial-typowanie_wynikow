package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.repository.TyperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTyperDataService implements TyperDataService {

    private final TyperRepository typerRepository;

    public DefaultTyperDataService(TyperRepository typerRepository) {
        this.typerRepository = typerRepository;
    }

    @Override
    public List<Typer> loadAllTypers() {
        return (List<Typer>) typerRepository.findAll();
    }

    @Override
    public Typer addTyper(Typer newTyper) {
        return typerRepository.save(newTyper);
    }

    @Override
    public Optional<Typer> loadTyperByNicname(String nickname) {
        return typerRepository.findByNickname(nickname);
    }

    @Override
    public Typer loadById(Integer typerId) {
        return typerRepository.findOne(typerId);
    }


}
