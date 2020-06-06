package edu.miu.cs.cs425.lab10.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student s) {
       return studentRepository.save(s);
    }

    @Override
    public Student findStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student s,Long id) {
        return studentRepository.findById(id).map(student -> {
            student.setCgpa(s.getCgpa());
            student.setDateOfEnrollment(s.getDateOfEnrollment());
            student.setFirst_name(s.getFirst_name());
            student.setIsInternational(s.getIsInternational());
            student.setLastName(s.getLastName());
            student.setMiddleName(s.getMiddleName());
            student.setStudentNumber(s.getStudentNumber());
            return studentRepository.save(student);
        }).orElseGet(() -> {
            return studentRepository.save(s);
        });
    }

}
