package ru.nikolay.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nikolay.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
private List<Person> people;
private static int PEOPLE_COUNT;
//jdbc:postgresql://localhost:5432/first_db
    {
        people=new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom",18, "tom@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",28, "bob@google.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate",30, "Kate@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",15, "Mike@yandex.ru"));

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
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());
    }
    public void delete(int id){
        people.removeIf(person -> person.getId() ==id);

        }
    }




