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
        people.add(new Person(++PEOPLE_COUNT, "Tom", 18,"tom@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 19,"bob@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Chert", 25,"chert@google.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 27,"kate@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
        }
        public void create(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);

        }

    public void update(int id, Person person) {
        for (Person persons:people) {
            if (persons.getId()==id){
                persons.setName(person.getName());
                persons.setAge(person.getAge());
                persons.setEmail(person.getEmail());
            }
        }
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
