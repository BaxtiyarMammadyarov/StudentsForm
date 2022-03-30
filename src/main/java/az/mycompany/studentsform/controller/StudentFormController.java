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


@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentFormController {
   final StudentService service;
    @RequestMapping(value = "/add",method = RequestMethod.POST , produces = {"application/json", "application/xml"}
            ,  consumes = {"application/x-www-form-urlencoded"})
   public String addStudent(@RequestBody RegistrationRequest request){


       service.add(request);

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
