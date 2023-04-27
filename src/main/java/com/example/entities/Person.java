/**
 @author Arnold González
 @version 1.0
 This class represents a basic data class example.
 Notice that this class is being done without the use of Hibernate and respective JPA annotations.
 */
package com.example.entities;
import java.io.Serializable;


public class Person implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String homeAddress;
    private String jobTitle;

    public Person(Integer id, String name, Integer age, String homeAddress, String jobTitle) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.homeAddress = homeAddress;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", homeAddress='" + homeAddress + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public String getJob() {
        return jobTitle;
    }
}