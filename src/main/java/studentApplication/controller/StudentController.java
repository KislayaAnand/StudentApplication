package studentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studentApplication.model.Student;
import studentApplication.service.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(allowedHeaders = "*")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    //http://localhost:8080/api/students
    @RequestMapping("/allstudents")
    public List<Student> getStudents() {
        return studentServiceImpl.getListOfStudents();
    }

    @RequestMapping("/id/{id}")
    public Student searchAllStudent(@PathVariable Long id) {
        return studentServiceImpl.getStudentById(id);
    }

    @RequestMapping("/firstname/{firstName}")
    public List<Student> searchStudentByFirstName(@PathVariable String firstName) {
        return studentServiceImpl.getStudentByFirstName(firstName);
    }

    @RequestMapping("/lastname/{lastName}")
    public List<Student> searchStudentByLastName(@PathVariable String lastName) {
        return studentServiceImpl.getStudentByLastName(lastName);
    }

    @RequestMapping("/add")
    public Student addNewStudentDetails(@RequestBody Student studentDetails) {
        return studentServiceImpl.createNewStudentRecord(studentDetails);
    }

    @PostMapping("/update/{id}")
    public Student updateStudentDetails(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentServiceImpl.updateStudentRecord(id, studentDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentDetails(@PathVariable Long id){
        studentServiceImpl.deleteStudentRecord(id);
    }

}
