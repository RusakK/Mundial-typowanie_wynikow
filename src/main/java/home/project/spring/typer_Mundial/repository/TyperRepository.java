package home.project.spring.typer_Mundial.repository;

import home.project.spring.typer_Mundial.model.Typer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TyperRepository extends CrudRepository<Typer, Integer> {

    @Query("SELECT t FROM Typer t WHERE t.nickname like :nickname")
    Optional<Typer> findByNickname(@Param("nickname") String nickname);
}
