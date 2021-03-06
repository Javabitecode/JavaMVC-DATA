package ru.nikolay.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {


    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 25,message = "Name should between 2 and 25 character")
    private String name;
    @Min(value = 12, message = "Age should be greater than 12")
    private int age;
    @Email(message = "Email should be valid")
    private String email;

    public Person(){

    }

    public Person(int id, String name, int age, String email) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
