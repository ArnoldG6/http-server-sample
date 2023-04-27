/**
 @author Arnold González
 @version 1.0
 Example class for Person related services. This class is meant to be used mainly by PersonWebService class and by other service class.
 */
package com.example.services;
import com.example.repositories.PersonRepository;
import com.example.entities.Person;
import com.google.gson.Gson;
import java.util.List;
import java.util.function.Predicate;


public class PersonService {
    private final PersonRepository personRepository;
    private final Gson gson;//Object to convert JSON to Person (or any other class).

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.gson = new Gson();
    }

    public String getAllPersons() {
        List<Person> persons = personRepository.getAllPersons();
        return gson.toJson(persons);
    }

    public String getPersonById(int id) {
        Person person = personRepository.filterPersons(p -> p.getId() == id).stream()
                .findFirst()
                .orElse(null);
        return gson.toJson(person);
    }

    public String addPerson(Person person) {
        personRepository.addPerson(person);
        return gson.toJson(person);
    }

    public String updatePerson(int id, Person updatedPerson) {
        personRepository.updatePerson(id, updatedPerson);
        return gson.toJson(updatedPerson);
    }

    public String deletePerson(int id) {
        Person person = personRepository.filterPersons(p -> p.getId() == id).stream()
                .findFirst()
                .orElse(null);
        if (person != null) {
            personRepository.deletePerson(person.getId());
            return gson.toJson(person);
        } else {
            return gson.toJson(null);
        }
    }

    public String filterPersonsByJob(String job) {
        Predicate<Person> jobFilter = person -> person.getJob().equalsIgnoreCase(job);
        List<Person> persons = personRepository.filterPersons(jobFilter);
        return gson.toJson(persons);
    }

    public String calculateAverageAge() {
        List<Person> persons = personRepository.getAllPersons();
        double averageAge;
        if (persons.isEmpty()) {
            averageAge = 0.0;
        } else {
            double sumOfAges = persons.stream()
                    .mapToInt(Person::getAge)
                    .sum();
            averageAge = sumOfAges / persons.size();
        }
        return gson.toJson(averageAge);
    }
}
