package edu.miu.cs.cs425.lab10.eregistrarwebapi.service;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;

import java.util.List;
import java.util.Optional;


public interface IStudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    Student findStudentById(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Student s,Long id);
}
