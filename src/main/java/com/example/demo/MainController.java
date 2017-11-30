package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${TravisGray} on 11/30/2017.
 */
@Controller
public class MainController {
@Autowired
CourseRepository courseRepository;

@Autowired
InstructorRepository instructorRepository;

@Autowired
StudentRepository studentRepository;




@RequestMapping("/")
    public String showindex (Model model
                             ){
    model.addAttribute("studentslist",studentRepository);
    model.addAttribute("instructorslist",instructorRepository);
    model.addAttribute("courseslist", courseRepository);
    return "index";
}

@GetMapping("/addstudent")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "addstudentform";
}

@GetMapping("/addInstructor")
    public String addInstructor(Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("instructor",instructor);
        return "addinstructorform";
}

@GetMapping("/addCourse")
    public String addCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "addcourseform";
}

}
