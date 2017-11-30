package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${TravisGray} on 11/30/2017.
 */
public interface StudentRepository extends CrudRepository<Student,Long> {
}
