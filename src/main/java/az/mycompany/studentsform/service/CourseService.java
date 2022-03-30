package az.mycompany.studentsform.service;

import az.mycompany.studentsform.dto.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {

    public List<Course> getAllCourse();

    public void add(Course course);
}
