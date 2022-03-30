package az.mycompany.studentsform.repository;

import az.mycompany.studentsform.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

    boolean existsByPhone(String phone);

    boolean existsByAddress(String address);
}
