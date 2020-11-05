package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.StudentDataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    List<Student> students;

    public StudentRepository() {
        this.students = StudentDataHolder.students;
    }

    public List<Student> findAllStudents(){
        return this.students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        List<Student> filtered = new ArrayList<>();

        for (Student student: students) {
            if(student.getName().contains(text) || student.getSurname().contains(text)){
                filtered.add(student);
            }
        }

        return filtered;
    }

    public Student findByUsername(String username){
        for (Student student: students) {
            if(student.getUsername().equals(username)){
                return student;
            }
        }

        return null;
    }

    public void save(Student s) {
        students.add(s);
    }
}