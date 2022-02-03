package ru.nikolay.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nikolay.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
private List<Person> people;
private static int PEOPLE_COUNT;

    {
        people=new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person person){
        Person person1 = show(id);
        person1.setName(person.getName());
    }
    public void delete(int id){
        people.removeIf(person -> person.getId() ==id);

        }
    }




