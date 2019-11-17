package com.example.freemarker.controller;

import com.example.freemarker.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentList {

    @RequestMapping("/list")
    public String list(Model model) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Tom", 80.4));
        list.add(new Student(2, "Dick", 92.2));
        list.add(new Student(3, "Harry", 79.8));
        list.add(new Student(4, "Jerry", 83.7));
        list.add(new Student(5, "Peter", 94.2));
        model.addAttribute("list", list);
        return "list";
    }
}
