package home.project.spring.typer_Mundial.service;

import home.project.spring.typer_Mundial.model.Customer;
import home.project.spring.typer_Mundial.model.MatchResults;
import home.project.spring.typer_Mundial.model.Typer;
import home.project.spring.typer_Mundial.repository.CustomerRepository;
import home.project.spring.typer_Mundial.repository.MatchResultsRepository;
import home.project.spring.typer_Mundial.repository.TyperRepository;

import java.util.Date;

public class DefaultTyperDataService implements TyperDataService {

    private CustomerRepository customerRepository;
    private MatchResultsRepository matchResultsRepository;
    private TyperRepository typerRepository;

    public DefaultTyperDataService(CustomerRepository customerRepository, MatchResultsRepository matchResultsRepository, TyperRepository typerRepository) {
        this.customerRepository = customerRepository;
        this.matchResultsRepository = matchResultsRepository;
        this.typerRepository = typerRepository;
    }

    @Override
    public Typer setGamesToCustomer(Customer customer, MatchResults matchResults) {

        Customer persistedCustomer = customerRepository
                .findByName(customer.getName())
                .orElseGet(() -> customerRepository.save(customer));

        Typer typer = new Typer();
        typer.setDate(new Date());
        typer.setCustomer(persistedCustomer);
        typer.setMatchResults(matchResults);
        return typerRepository.save(typer);
    }

    @Override
    public MatchResults typeMatches(Customer customer, int game1, int game2, int game3, int game4, int game5, int game6, int game7, int game8) {
        Customer persistedCustomer = customerRepository
                .findByName(customer.getName())
                .orElseGet(() -> customerRepository.save(customer));

        MatchResults matchResults = new MatchResults();
        matchResults.setCustomer(persistedCustomer);
        matchResults.setGame_1A_2B(game1);
        matchResults.setGame_1B_2A(game2);
        matchResults.setGame_1C_2D(game3);
        matchResults.setGame_1D_2C(game4);
        matchResults.setGame_1E_2F(game5);
        matchResults.setGame_1F_2E(game6);
        matchResults.setGame_1G_2H(game7);
        matchResults.setGame_1H_2G(game8);
        matchResults.setDate(new Date());
        
        return matchResultsRepository.save(matchResults);
    }
}
