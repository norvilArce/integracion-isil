package pe.isil.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pe.isil.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class personLoader implements CommandLineRunner {

    private final String URL = "http://localhost:8080/";

    private final RestTemplate restTemplate;

    public personLoader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Iniciando ...");

        personList();
        addPerson();
        updatePerson();
        deletePerson();
        personList();
    }

    private void deletePerson() {
        log.info("Eliminar una persona");

        try{
            restTemplate.delete(URL + "api/persons/1");
        }catch (HttpClientErrorException e){
            log.error("El ID no existe");
        }
    }

    private void updatePerson() {
        log.info("Actualizar una persona");
        Person person = new Person(1, "Henry", "Morgan", 55);
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> exchange = restTemplate.exchange(URL + "api/persons/1", HttpMethod.PUT, request, Person.class);
        if (exchange.getStatusCode().equals(HttpStatus.OK)){
            Person body = exchange.getBody();
            log.info("Persona actualizada: {}", body);
        }
    }

    private void addPerson() {
        log.info("Registrar una persona");
        Person person = new Person(null, "Jean", "Laffite", 45);
        HttpEntity<Person> request = new HttpEntity<>(person);
        Person personResponse = restTemplate.postForObject(URL + "api/persons", request, Person.class);
        log.info("New person: {}", personResponse);
    }

    private void personList() {
        ResponseEntity<Person[]> personResponse = restTemplate.getForEntity(URL + "api/persons", Person[].class);
        if (personResponse.getStatusCode().is2xxSuccessful()) {
            Person[] body = personResponse.getBody();
//            body.forEach(p -> log.info(p.toString()));
            /*List<String> nameList = Arrays.stream(body)
                    .map(Person::getFirstName)
                    .collect(Collectors.toList());
            log.info("los nombres son: {}", nameList);*/
            List<Person> people = Arrays.asList(body);
            people.stream().forEach(p -> log.info("Person: {}", p));
        }
    }

    @Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
