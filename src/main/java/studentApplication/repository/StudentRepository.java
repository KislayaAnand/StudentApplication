package studentApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentApplication.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameIgnoreCase(String firstName);
    List<Student> findByLastNameIgnoreCase(String firstName);
    List<Student> findByStandardIgnoreCase(String standard);
    List<Student> findByContactNumber(Double contactNumber);

}
