package pe.isil.resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Person;
import pe.isil.service.PersonService;

import java.util.List;

@RequestMapping("/api/persons")
@RestController
public class PersonResource {

    private final PersonService personService;

    public PersonResource(@Qualifier("personDBService") PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personService.getAll();
        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.create(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Integer id) {
        Person currentPerson = personService.findById(id);
        if (currentPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setId(id);
        personService.update(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {
        Person currentPerson = personService.findById(id);
        if (currentPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.delete(currentPerson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        Person currentPerson = personService.findById(id);
        if (currentPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentPerson, HttpStatus.OK);
    }
}