package contacts.data;

import contacts.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findStudentByName(String name);

    List<Student> findAllByName(String name);

    Student findStudentByPhoneNumber(String phoneNumber);

    @Query("{'address.city': ?0}")
    List<Student> findAllByCity(String city);

}
