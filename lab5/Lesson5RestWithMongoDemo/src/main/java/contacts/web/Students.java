package contacts.web;

import contacts.domain.Student;

import java.util.Collection;

public class Students {

    private Collection<Student> students;

    public Students(Collection<Student> students) {
        this.students = students;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
