package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
