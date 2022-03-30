package az.mycompany.studentsform.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name;
    String surname;
    String address;
    String phone;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    CourseEntity course;
}
