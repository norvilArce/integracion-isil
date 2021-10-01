package pe.isil.svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    private String dni;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;
    private String biography;
    /*@Column(name = "book_isbn")
    private String bookIsbn;*/

    @ManyToOne
    @JoinColumn(name = "book_isbn"/*, insertable = false, updatable = false*/)
    private Book book;

}
