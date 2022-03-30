package az.mycompany.studentsform.repository;

import az.mycompany.studentsform.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity,Long> {
    CourseEntity findByCourseName(String courseName);
}
