package az.mycompany.studentsform.service.impl;

import az.mycompany.studentsform.dto.Course;
import az.mycompany.studentsform.dto.StudentDto;
import az.mycompany.studentsform.entity.CourseEntity;
import az.mycompany.studentsform.entity.StudentEntity;
import az.mycompany.studentsform.repository.CourseRepo;
import az.mycompany.studentsform.repository.StudentRepo;
import az.mycompany.studentsform.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {

    final StudentRepo studentRepo;
    final CourseRepo courseRepo;


    @Override
    public List<StudentDto> getAllStudent() {
        return studentRepo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void add(StudentDto dto) {
        if(studentRepo.existsByPhone(dto.getPhone())){
            throw new RuntimeException("phone alride exist");
        }
        else if(studentRepo.existsByAddress(dto.getAddress())){
            throw new RuntimeException("Address alride exist");
        }else{
            CourseEntity course=courseRepo.findByCourseName(dto.getCourse().getCourseName());

            if(course==null){
                CourseEntity courseEntity=CourseEntity.builder()
                        .courseName(dto.getCourse().getCourseName())
                        .build();
                courseEntity=courseRepo.save(courseEntity);
                StudentEntity studentEntity= dtoToEntity(dto);
                studentEntity.setCourse(courseEntity);
                studentRepo.save(studentEntity);

            }
            else {
                StudentEntity studentEntity=dtoToEntity(dto);
                studentRepo.save(studentEntity);
            }

        }


    }
    private StudentEntity dtoToEntity(StudentDto dto){

        return  new StudentEntity().builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .course(new CourseEntity(dto.getId(),dto.getCourse().getCourseName()))
                .build();
    }
    private StudentDto entityToDto(StudentEntity entity){
        return new StudentDto().builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .course(new Course(entity.getCourse().getId(),entity.getCourse().getCourseName()))
                .build();
    }
    @PostConstruct
    private void intStudent(){
        CourseEntity course=new CourseEntity().builder()
                .courseName("test")
                .build();
        course=courseRepo.save(course);

        StudentEntity entity=new StudentEntity().builder()
                .name("Baxtiyar")
                .surname("Mammadyarov")
                .phone("0552009261")
                .address("Azərbaycan")
                .course(course)
                .build();
        studentRepo.save(entity);

    }
}
