/**
 @author Arnold González
 @version 1.0
 This class represents an example of a class in charge of DB connection, essentially for Person table operations.
 */
package com.example.repositories;
import com.example.entities.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonRepository {
    private List<Person> personList;

    public PersonRepository(){
        personList = new ArrayList<>();
        initPersons(); //Initialize data from a hard-coded variable
    }

    private void initPersons(){
        personList.add(new Person(1,"John Smith", 35, "123 Main St", "Software Engineer"));
        personList.add(new Person(2,"Mary Johnson", 42, "456 Elm St", "Marketing Manager"));
        personList.add(new Person(3,"Bob Jones", 28, "789 Oak St", "Sales Representative"));
        personList.add(new Person(4,"Sarah Lee", 29, "321 Maple Ave", "Project Manager"));
        personList.add(new Person(5,"David Lee", 45, "987 Cherry Blvd", "Chief Financial Officer"));
        personList.add(new Person(6,"Emily Brown", 31, "567 Pine Rd", "Human Resources Manager"));
        personList.add(new Person(7,"Michael Davis", 27, "234 Cedar Ln", "Software Developer"));
        personList.add(new Person(8,"Jessica Kim", 38, "876 Walnut St", "Product Manager"));
        personList.add(new Person(9,"William Chen", 33, "543 Birch St", "Data Scientist"));
    }
    public List<Person> getAllPersons(){
         return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void updatePerson(int id, Person updatedPerson){
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getId() == id) {
                personList.set(i, updatedPerson);
                break;
            }
        }
    }

    public List<Person> filterPersons(Predicate<Person> filter){
        /*
        * Use example
        *
        Predicate<Person> softwareEngineerFilter = person -> person.getJob().equals("Software Engineer");
        List<Person> softwareEngineers = personRepository.filterPersons(softwareEngineerFilter);
        * */
        return personList.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public void deletePerson(int id){
        personList.removeIf(person -> person.getId() == id);
    }


}

