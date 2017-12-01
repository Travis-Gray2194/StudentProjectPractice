package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by ${TravisGray} on 11/30/2017.
 */
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Instructor() {
    }


    public Instructor(String firstname, String lastname, String contactnumber, String email, Set<Course> courses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactnumber = contactnumber;
        this.email = email;
        this.courses = courses;
    }

    @NotEmpty
    @NotNull
    private String firstname;
    private String lastname;
    private String contactnumber;
    private String email;

    @ManyToMany()
private Set<Course>courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
