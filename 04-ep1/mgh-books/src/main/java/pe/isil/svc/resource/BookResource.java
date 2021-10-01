package pe.isil.svc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.svc.model.Book;
import pe.isil.svc.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>>getBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getById(@PathVariable String isbn) {
        if (bookService.findById(isbn)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(bookService.findById(isbn), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.create(book), HttpStatus.CREATED);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable String isbn){
        if (bookService.findById(isbn)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(bookService.update(book), HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity deleteBook(@PathVariable String isbn){
        if (bookService.findById(isbn)==null){
            return new ResponseEntity("Aqui no hay nada", HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity("Libro eliminiado", HttpStatus.CONTINUE);
    }

}
