/**
 @author Arnold González
 @version 1.0
 Example class for Person related services. This class is meant to be used mainly by PersonWebService class and by other service class.
 */
package com.example.web.services;
import com.example.entities.Person;
import com.example.repositories.PersonRepository;
import com.example.services.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") //Cross Origin * (CORS) indicates to this class, that any client can connect to this services. This filter can be applied to each one of the services.
public class PersonWebService {
    //Instancia de la clase que contiene la lógica de negocio para el servicio web
    private PersonService personService;
    //Constructor que recibe una instancia de la clase que contiene la lógica de negocio para el servicio web
    public PersonWebService() {
        this.personService = new PersonService(new PersonRepository());//This constructor has to be different
        //when using spring dependency injection
    }

    @GetMapping("/persons")
    public String getPersons() {//Returns a Json of persons (It can return List<Person> with Spring way)

        return personService.getAllPersons();
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
}
