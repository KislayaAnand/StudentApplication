package studentApplication.service;

import org.springframework.stereotype.Service;
import studentApplication.model.Student;
import studentApplication.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getListOfStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) throws RuntimeException{
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("No Student Found With Id: "+id));
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstNameIgnoreCase(firstName);
    }

    public List<Student> getStudentByLastName(String lastName) {
        return studentRepository.findByLastNameIgnoreCase(lastName);
    }

    public Student createNewStudentRecord(Student studentDetails) {
        return studentRepository.save(studentDetails);
    }

    public Student updateStudentRecord(Long id, Student studentDetails) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setStandard((studentDetails.getStandard()));
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setContactNumber(studentDetails.getContactNumber());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentRecord(Long id) {
        studentRepository.deleteById(id);
    }
}
