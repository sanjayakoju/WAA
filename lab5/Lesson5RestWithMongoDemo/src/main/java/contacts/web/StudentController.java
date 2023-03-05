package contacts.web;

import contacts.domain.Student;
import contacts.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAll() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<?> getAllByName(@PathVariable String name) {
        List<Student> students = studentService.getAllByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/students/{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        studentService.delete(name);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @GetMapping("/students/phone/{phone}")
    public ResponseEntity<?> getByPhone(@PathVariable String phone) {
        Student student = studentService.getByPhone(phone);
        if(student == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Student with phone number = "
                    + phone + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students/city/{city}")
    public ResponseEntity<?> getAllByCity(@PathVariable String city) {
        Students students = new Students(studentService.getAllByCity(city));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
