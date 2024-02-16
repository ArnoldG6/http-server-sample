/**
 @author Arnold González
 @version 1.0
 Example class for Person related services. This class is meant to be used mainly by PersonWebService class and by other service class.
 */
package com.example.web.services;
import com.example.entities.Person;
import com.example.repositories.PersonRepository;
import com.example.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") //Cross Origin * (CORS) indicates to this class, that any client can connect to this services. This filter can be applied to each one of the services.
public class PersonWebService {
    private static final Logger logger = LoggerFactory.getLogger(PersonWebService.class);
    //Instancia de la clase que contiene la lógica de negocio para el servicio web
    private PersonService personService;
    //Constructor que recibe una instancia de la clase que contiene la lógica de negocio para el servicio web
    public PersonWebService() {
        this.personService = new PersonService(new PersonRepository());//This constructor has to be different
        //when using spring dependency injection
    }

    @GetMapping("/persons")
    public String getPersons() throws Exception {//Returns a Json of persons (It can return List<Person> with Spring way)
        logger.info("PersonWebService:getPersons: Triggering endpoint /persons with GET method");
        return personService.getAllPersons();
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        logger.info("PersonWebService:addPerson: Triggering endpoint /persons with POST method");
        return personService.addPerson(person);
    }
}
