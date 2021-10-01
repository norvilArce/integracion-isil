package pe.isil.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.svc.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
