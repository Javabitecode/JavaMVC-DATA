package ru.nikolay.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nikolay.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT;
private List<Person> peopleList;

    {
        peopleList.add(new Person(++COUNT, "Bob"));
        peopleList.add(new Person(++COUNT, "Tom"));
        peopleList.add(new Person(++COUNT, "Hester"));
        peopleList.add(new Person(++COUNT, "Lina"));
        peopleList.add(new Person(++COUNT, "Mikel"));
    }

    public List<Person> index(){
        return peopleList;
    }

    public Person show(int id){
        return peopleList.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
