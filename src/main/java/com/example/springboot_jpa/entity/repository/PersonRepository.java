package com.example.springboot_jpa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_jpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
