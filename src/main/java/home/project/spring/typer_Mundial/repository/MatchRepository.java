package home.project.spring.typer_Mundial.repository;

import home.project.spring.typer_Mundial.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MatchRepository extends CrudRepository<Match, Integer> {

    @Query("SELECT m FROM Match m WHERE m.typer = :typerId")
    Optional<Match> findByTyper(@Param("typerId") Integer typerId);

}
