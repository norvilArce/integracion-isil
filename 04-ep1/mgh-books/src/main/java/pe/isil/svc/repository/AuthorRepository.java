package pe.isil.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.svc.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
