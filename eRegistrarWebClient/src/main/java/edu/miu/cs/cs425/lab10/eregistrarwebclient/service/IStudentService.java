package edu.miu.cs.cs425.lab10.eregistrarwebclient.service;

import edu.miu.cs.cs425.lab10.eregistrarwebclient.model.Student;

import java.util.List;


public interface IStudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    Student findStudentById(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Student s,Long id);
}
