package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Typer;

import java.util.List;
import java.util.Optional;

public interface TyperDataService {

    List<Typer> loadAllTypers();

    Typer addTyper(Typer newTyper);

    Optional<Typer> loadTyperByNicname(String nickname);


}
