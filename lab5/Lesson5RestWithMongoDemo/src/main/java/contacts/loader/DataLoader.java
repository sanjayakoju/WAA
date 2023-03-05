package contacts.loader;

import contacts.domain.Address;
import contacts.domain.Student;
import contacts.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    static StudentService studentService;

    public DataLoader(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void load() {
        Student student1 = new Student();
        student1.setName("Sanjaya");
        student1.setEmail("sanjayakoju@gmail.com");
        student1.setPhoneNumber("6418192555");
        Address address1 = new Address();
        address1.setCity("Seattle");
        address1.setStreet("Thistle ST");
        address1.setZip("12345");
        student1.setAddress(address1);

        Student student2 = new Student();
        student2.setName("Susan");
        student2.setEmail("susa@gmail.com");
        student2.setPhoneNumber("6418192550");
        Address address2 = new Address();
        address2.setCity("Fairfield");
        address2.setStreet("Burlington AVE");
        address2.setZip("23456");
        student2.setAddress(address2);

        Student student3 = new Student();
        student3.setName("Dina");
        student3.setEmail("dina@gmail.com");
        student3.setPhoneNumber("6418192551");
        Address address3 = new Address();
        address3.setCity("Fairfield");
        address3.setStreet("Othello AVE");
        student3.setAddress(address3);

        Student student4 = new Student();
        student4.setName("Dilmaya");
        student4.setEmail("dimaya@gmail.com");
        student4.setPhoneNumber("6418192552");
        Address address4 = new Address();
        address4.setCity("Fairfield");
        address4.setStreet("Othello AVE");
        student4.setAddress(address4);

        Student student5 = new Student();
        student5.setName("Laxmi Sundar");
        student5.setEmail("laxmi@gmail.com");
        student5.setPhoneNumber("6418192554");
        Address address5 = new Address();
        address5.setCity("Fairfield");
        address5.setStreet("Othello AVE");
        address5.setZip("34667");
        student5.setAddress(address4);

        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);
        studentService.save(student4);
        studentService.save(student5);
    }
}
