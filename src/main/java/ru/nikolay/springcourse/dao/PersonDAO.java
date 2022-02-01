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
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Nick"));
        people.add(new Person(++PEOPLE_COUNT, "Lola"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person ->person.getId()==id).findAny().orElse(null);
    }
}
