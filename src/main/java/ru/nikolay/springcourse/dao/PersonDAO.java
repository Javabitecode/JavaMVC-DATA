package ru.nikolay.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.nikolay.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {
//jdbc:postgresql://localhost:5432/first_db

JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
    return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id =?",new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);

    }

    public void save(Person person){
    jdbcTemplate.update("INSERT INTO Person VALUES (1,?,?,?)", person.getName(), person.getAge(), person.getEmail());

    }
    public void update(int id, Person person){
    jdbcTemplate.update("UPDATE Person SET name =?, age=?, email=? WHERE id=?", person.getName(), person.getAge(), person.getEmail(), id);

    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

    }
}




