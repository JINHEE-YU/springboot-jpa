package com.example.springboot_jpa.api;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_jpa.entity.Person;
import com.example.springboot_jpa.entity.repository.PersonRepository;
import com.example.springboot_jpa.entity.repository.StockPriceRepository;

@RestController
@RequestMapping("/jpa")
public class PostgreAPIController {
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private StockPriceRepository stockPriceRepository;

  @GetMapping("/person")
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @PostMapping("/person")
  public Person createPerson(@RequestBody Person person) {
    return personRepository.save(person);
  }

  @GetMapping("/stock")
  public List<Object> findDuplicateTime(@RequestParam("collectTime") OffsetDateTime collectTime) {// OffsetDateTime
    List<Object> result = stockPriceRepository.findDuplicateTimes(collectTime);
    return result;
  }
}
