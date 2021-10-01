package pe.isil.svc.service;

import org.springframework.stereotype.Service;
import pe.isil.svc.model.Author;
import pe.isil.svc.model.Book;
import pe.isil.svc.repository.BookRepository;

import java.util.List;

@Service
public class BookService implements CrudService<Book, String> {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        book.addAuthors(book.getAuthors());
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
