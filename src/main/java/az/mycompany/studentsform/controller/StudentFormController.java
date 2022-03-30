package az.mycompany.studentsform.controller;


import az.mycompany.studentsform.dto.StudentDto;
import az.mycompany.studentsform.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentFormController {
   final StudentService service;
   @PostMapping("/add")
   public String addStudent(@RequestBody StudentDto dto){

       service.add(dto);

       return "redirect:/";

   }

   @GetMapping("/")
   public String getAllStudent(Model model){
    model.addAttribute("students",service.getAllStudent());
       return "index";
   }
    @GetMapping("/registration")
    public String registration(Model model){

        return "registration";
    }




}
