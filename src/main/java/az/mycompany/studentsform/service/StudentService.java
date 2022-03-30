package az.mycompany.studentsform.service;

import az.mycompany.studentsform.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<StudentDto> getAllStudent();

    public void add(StudentDto dto);
}
