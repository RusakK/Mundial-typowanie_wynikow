package home.project.spring.typer_Mundial.repository;

import home.project.spring.typer_Mundial.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByName(String name);
}
