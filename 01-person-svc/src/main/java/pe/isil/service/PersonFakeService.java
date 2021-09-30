package pe.isil.service;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import pe.isil.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonFakeService {

    AtomicInteger id = new AtomicInteger(10);
    List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Jack", "Rackham", 40),
                    new Person(2, "Edward", "Teach", 35)
            )
    );

    public List<Person> getAll(){
        return personList;
    }

    public void create(Person person){
        person.setId((id.getAndIncrement()));
        personList.add(person);
    }

    public void delete(Person person){
        personList.remove(person);
    }

    public void update(Person person){
        Person currentPerson = findById(person.getId());
        if (currentPerson!=null){
            int index = personList.indexOf(currentPerson);
            personList.set(index, person);
        }
    }

    public Person findById(Integer id) {
        return personList.stream()
                .filter(person -> id.equals(person.getId()))
                .findFirst()
                .orElse(null);
    }

}
