package pe.isil.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;
    private String summary;
    private LocalDate publicationDate;
    private Integer numberOfPages;
    private String language;


    @JsonIgnoreProperties("book")
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Author> authors;

    public void addAuthors(List<Author> authors){
        authors.forEach(author -> author.setBook(this));
        this.setAuthors(authors);
    }

}
