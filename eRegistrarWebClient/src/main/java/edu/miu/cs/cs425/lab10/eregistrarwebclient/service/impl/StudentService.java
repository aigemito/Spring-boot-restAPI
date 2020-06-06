package edu.miu.cs.cs425.lab10.eregistrarwebclient.service.impl;

import edu.miu.cs.cs425.lab10.eregistrarwebclient.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebclient.model.StudentList;
import edu.miu.cs.cs425.lab10.eregistrarwebclient.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    RestTemplate restTemplate;

    String baseURL="http://localhost:8080/eregistrar/api/student";

    @Override
    public List<Student> getAllStudents() {

       StudentList studentList= restTemplate.getForObject(baseURL+"/studentList", StudentList.class);
       return studentList.getStudents();
    }

    @Override
    public Student save(Student s) {
        System.out.println("saving student...");
        return restTemplate.postForObject(baseURL+"/register",s,Student.class);
    }

    @Override
    public Student findStudentById(Long id){
        return restTemplate.getForObject(baseURL+"/get/"+id,Student.class);

    }

    @Override
    public void deleteStudent(Long id){
        restTemplate.delete(baseURL+"/delete/"+id);
//        studentRepository.delete(s);

    }


    @Override
    public Student updateStudent(Student s,Long id) {
        return null;
//        return studentRepository.findById(id).map(student -> {
//            student.setCgpa(s.getCgpa());
//            student.setDateOfEnrollment(s.getDateOfEnrollment());
//            student.setFirst_name(s.getFirst_name());
//            student.setIsInternational(s.getIsInternational());
//            student.setLastName(s.getLastName());
//            student.setMiddleName(s.getMiddleName());
//            student.setStudentNumber(s.getStudentNumber());
//            return studentRepository.save(student);
//        }).orElseGet(() -> {
//            return studentRepository.save(s);
//        });
    }

}
