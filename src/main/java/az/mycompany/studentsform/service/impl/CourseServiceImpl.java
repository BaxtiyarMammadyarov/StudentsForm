package az.mycompany.studentsform.service.impl;

import az.mycompany.studentsform.dto.Course;
import az.mycompany.studentsform.repository.CourseRepo;
import az.mycompany.studentsform.service.CourseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseServiceImpl implements CourseService {

    final CourseRepo repo;
    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public void add(Course course) {


    }


}
