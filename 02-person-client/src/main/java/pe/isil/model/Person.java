package pe.isil.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
}