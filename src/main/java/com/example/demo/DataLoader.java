package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data. . .");
//
//public Instructor(String firstname, String lastname, String contactnumber, String email) {
//            this.firstname = firstname;
//            this.lastname = lastname;
//            this.contactnumber = contactnumber;
//            this.email = email;
//            this.courses= new HashSet<>();
//
//        }

        Course course = new Course("Biology","100","Fundamentals Concepts");
        courseRepository.save(course);

        Course course2 = new Course("Math","100","Fundamentals Concepts");
        courseRepository.save(course2);


        Instructor instructor = new Instructor("Teacher Jim","Gray","3016310818","jim@montgormerycollege.edu");
        instructor.addCourse(course);
        instructorRepository.save(instructor);

        Instructor instructor2 = new Instructor("Teacher Tim","Long","3016310818","tim@montgormerycollege.edu");
        instructor2.addCourse(course2);
        instructorRepository.save(instructor2);

        Student student = new Student("Jack","Francios","2034569081","jack@montgromerycollge.edu");
        student.addCourse(course);
        studentRepository.save(student);

        Student student2 = new Student("Brooke","Dean","2034569081","Brooke@montgromerycollge.edu");
        student.addCourse(course2);
        studentRepository.save(student);


    }

}
