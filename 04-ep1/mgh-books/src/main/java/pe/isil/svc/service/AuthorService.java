package pe.isil.svc.service;

import org.springframework.stereotype.Service;
import pe.isil.svc.model.Author;
import pe.isil.svc.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService implements CrudService<Author, String> {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(String dni) {
        authorRepository.deleteById(dni);
    }

    @Override
    public Author findById(String dni) {
        return authorRepository.findById(dni).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
