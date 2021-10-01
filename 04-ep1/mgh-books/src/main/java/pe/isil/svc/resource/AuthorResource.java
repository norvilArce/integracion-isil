package pe.isil.svc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.svc.model.Author;
import pe.isil.svc.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorResource {

    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>>getAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Author> getById(@PathVariable String dni) {
        if (authorService.findById(dni)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Author>(authorService.findById(dni), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return new ResponseEntity<Author>(authorService.create(author), HttpStatus.CREATED);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable String dni){
        if (authorService.findById(dni)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Author>(authorService.update(author), HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity deleteAuthor(@PathVariable String isbn){
        if (authorService.findById(isbn)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        authorService.delete(isbn);
        return new ResponseEntity("Autor eliminiado", HttpStatus.CONTINUE);
    }

}
