package com.example.springboot_jpa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_jpa.entity.Person;
import com.example.springboot_jpa.entity.repository.PersonRepository;

@RestController
@RequestMapping("/jpa/person")
public class PostgreAPIController {
  @Autowired
  private PersonRepository personRepository;

  @GetMapping
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @PostMapping
  public Person createPerson(@RequestBody Person person) {
    return personRepository.save(person);
  }
}
