package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Customer;
import home.project.spring.typer_Mundial.model.MatchResults;
import home.project.spring.typer_Mundial.model.Typer;

public interface TyperDataService {

    Typer setGamesToCustomer(Customer customer, MatchResults matchResults);


    MatchResults typeMatches(Customer customer, int game1, int game2, int game3, int game4, int game5, int game6, int game7, int game8);
}
