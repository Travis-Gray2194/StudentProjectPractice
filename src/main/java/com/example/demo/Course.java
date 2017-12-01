package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by ${TravisGray} on 11/30/2017.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    private String title;
    private String coursenumber;
    private String description;


    public Course() {
    }

    public Course(String title, String coursenumber, String description, Set<Instructor> instructors, Set<Student> students) {
        this.title = title;
        this.coursenumber = coursenumber;
        this.description = description;
        this.instructors = instructors;
        this.students = students;
    }

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor>instructors;

    @ManyToMany( mappedBy ="courses")
    private Set<Student>students;



    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(String coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
