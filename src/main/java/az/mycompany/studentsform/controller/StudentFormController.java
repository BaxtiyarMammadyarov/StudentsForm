package az.mycompany.studentsform.controller;


import az.mycompany.studentsform.dto.RegistrationRequest;
import az.mycompany.studentsform.dto.StudentDto;
import az.mycompany.studentsform.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentFormController {
    final StudentService service;


    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("request", new RegistrationRequest());
        return "register_form";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("request") RegistrationRequest request) {


        service.add(request);

        return "redirect:/";

    }

    @GetMapping("/")
    public String getAllStudent(Model model) {
        List<StudentDto> studentDtoList=service.getAllStudent();
        System.out.println(studentDtoList);
        model.addAttribute("students", studentDtoList);
        return "index";
    }



}
