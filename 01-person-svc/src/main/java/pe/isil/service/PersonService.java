package pe.isil.service;

import pe.isil.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    void create(Person person);
    void delete(Person person);
    void update(Person person);
    Person findById(Integer id);
}
