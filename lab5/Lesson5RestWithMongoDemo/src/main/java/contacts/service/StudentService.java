package contacts.service;

import contacts.data.StudentRepository;
import contacts.domain.Student;
import contacts.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmailSender emailSender;

    public void save(Student student) {
        studentRepository.save(student);
        emailSender.sendEmail(student.getEmail(), "Hello");
    }

    public void update(Student student) {
        studentRepository.save(student);
        emailSender.sendEmail(student.getEmail(),"Update");
    }

    public void delete(String name) {
        Student student = studentRepository.findStudentByName(name);
        studentRepository.delete(student);
        emailSender.sendEmail(student.getEmail(), "Bye");
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> getAllByName(String name) {
        List<Student> studentList = studentRepository.findAllByName(name);
        return studentList;
    }

    public Student getByPhone(String phoneNumber) {
        Student student = studentRepository.findStudentByPhoneNumber(phoneNumber);
        return student;
    }

    public List<Student> getAllByCity(String city) {
        List<Student> studentList = studentRepository.findAllByCity(city);
        return studentList;
    }
}
