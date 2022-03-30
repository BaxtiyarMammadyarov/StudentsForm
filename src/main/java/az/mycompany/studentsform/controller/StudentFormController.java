package az.mycompany.studentsform.controller;


import az.mycompany.studentsform.dto.RegistrationRequest;
import az.mycompany.studentsform.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentFormController {
    final StudentService service;


    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("request", new RegistrationRequest());
        return "register_form";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("request") RegistrationRequest request) {
        System.out.println(request);

        service.add(request);

        return "redirect:/";

    }

    @GetMapping("/")
    public String getAllStudent(Model model) {
        model.addAttribute("students", service.getAllStudent());
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        return "register_form";
    }


}
