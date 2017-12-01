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


    @GetMapping("/addstudenttocourse/{id}")
    public String addStudenttoCourse(@PathVariable("id")long studentid,Model model){
        model.addAttribute("student",studentRepository.findOne(new Long(studentid)));
        model.addAttribute("courselist",courseRepository.findAll());
        return "courseaddstudents";
    }

    @PostMapping("addstudenttocourse/{id}")
    public String addStudenttoCourse(@RequestParam("student.id")String studentid, @RequestParam("course.id")String courseid,Model model){
        Student studid = studentRepository.findOne(new Long(studentid));
        studid.addCourse(courseRepository.findOne(new Long(courseid)));
        studentRepository.save(studid);

        model.addAttribute("studentslist",studentRepository.findAll());
        model.addAttribute("courseslist", courseRepository.findAll());
        return "redirect:/";
    }

}
