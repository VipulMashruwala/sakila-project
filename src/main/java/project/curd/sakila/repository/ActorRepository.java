package project.curd.sakila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.curd.sakila.entity.Actor;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    public List<Actor> findAll();
    public Optional<Actor> findActorById(Integer Id);
}
