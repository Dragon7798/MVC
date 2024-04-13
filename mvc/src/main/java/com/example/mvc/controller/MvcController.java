package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.repo.MasterRepo;
import com.example.mvc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {

    @Autowired
    MasterRepo repo;
    @Autowired
    StudentRepo studentRepo;


    @GetMapping("/get")
    String hello() {
        return "home";
    }


    @GetMapping("/index")
    String index(Model model) {
        model.addAttribute("query", repo.findAll());
        return "index";
    }

    @GetMapping("/students")
    String getStudents(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "student";
    }

    @GetMapping("/student/add")
    String studentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add";
    }

    @PostMapping("/post")
    String save(@ModelAttribute("student") Student student) {
        studentRepo.save(student);
        return "redirect:/students";
    }


}
