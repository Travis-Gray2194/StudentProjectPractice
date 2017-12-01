package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showindex(Model model){
    model.addAttribute("studentslist",studentRepository);
    model.addAttribute("instructorslist",instructorRepository);
    model.addAttribute("courseslist", courseRepository);
    return "index";
}

@GetMapping("/addStudent")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "addstudentform";
}

@PostMapping("/addStudent")
public String saveStudent(@ModelAttribute ("student") Student student){
        studentRepository.save(student);
        return "addstudentform";
}

@GetMapping("/addInstructor")
    public String addInstructor(Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("instructor",instructor);
        return "addinstructorform";
}

    @PostMapping("/addInstructor")
    public String saveInstructor(@ModelAttribute ("instructor") Instructor instructor){
        instructorRepository.save(instructor);
        return "addinstructorform";
    }

@GetMapping("/addCourse")
    public String addCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "addcourseform";
}

    @PostMapping("/addCourse")
    public String saveCourse(@ModelAttribute ("course") Course course){
        courseRepository.save(course);
        return "addcourseform";
    }


    @GetMapping("/addinstructortocourse/{id}")
    public String addInstructortoCourse(@PathVariable("id")long instructorid,Model model){
        model.addAttribute("instructor",instructorRepository.findOne(new Long(instructorid)));
        model.addAttribute("courselist",courseRepository.findAll());
        System.out.println("Count for Course Repo:"+courseRepository.count());
        return "instructoraddcourse";
    }

    @PostMapping("/addinstructortocourse")
    public String addInstructortoCourse(@RequestParam("instructorid")String instructorid, @RequestParam("courseid")String courseid,Model model){
        Instructor instructor = instructorRepository.findOne(new Long(instructorid));
        System.out.println("Instructor ID:"+ instructorid);
        System.out.println("Course ID:"+ courseid);
        instructor.addCourse(courseRepository.findOne(new Long(courseid)));
        instructorRepository.save(instructor);
        model.addAttribute("studentlist",studentRepository.findAll());
        model.addAttribute("instructorslist",instructorRepository.findAll());
        return "redirect:/";
    }


    @GetMapping("/addstudenttocourse/{id}")
    public String addStudenttoCourse(@PathVariable("id")long studentid,Model model){
        model.addAttribute("student",studentRepository.findOne(new Long(studentid)));
        model.addAttribute("courselist",courseRepository.findAll());
        System.out.println("Count for Student Repo"+studentRepository.count());
        return "courseaddstudents";
    }

    @PostMapping("/addstudenttocourse/{id}")
    public String addStudenttoCourse(@RequestParam("studentid")String studentid, @RequestParam("courseid")String courseid,Model model){
        Student student = studentRepository.findOne(new Long(studentid));
        student.addCourse(courseRepository.findOne(new Long(courseid)));
        studentRepository.save(student);
        model.addAttribute("studentslist",studentRepository.findAll());
        model.addAttribute("courseslist", courseRepository.findAll());
        return "redirect:/";
    }

}
