package az.mycompany.studentsform.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentDto {

    Long id ;
    String name;
    String surname;
    String address;
    String phone;
    Course course;




}
