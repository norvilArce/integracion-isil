package pe.isil.svc.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.isil.svc.model.Author;
import pe.isil.svc.repository.AuthorRepository;

@Component
public class AuthorLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    public AuthorLoader(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Author author = new Author();
        author.setDni("21665435");
        author.setFirstName("Robert");
        author.setLastNameFather("Louis");
        author.setLastNameMother("Stevenson");
        author.setAge(34);
        author.setBiography("Nacio, crecio, dibujo un mapa del tesoro, escribio y murio");

        authorRepository.save(author);*/
    }
}
