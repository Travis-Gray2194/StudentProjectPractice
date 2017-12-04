package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${TravisGray} on 11/30/2017.
 */
public interface CourseRepository extends CrudRepository<Course,Long> {
    Iterable<Course> findAllByTitleContainingIgnoreCase(String search);
//    long countAllByTitleContaining(String search);
}
