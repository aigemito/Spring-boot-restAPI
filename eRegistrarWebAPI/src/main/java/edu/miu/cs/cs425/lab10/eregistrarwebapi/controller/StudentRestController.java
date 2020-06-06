package edu.miu.cs.cs425.lab10.eregistrarwebapi.controller;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.StudentList;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRestController {

    @Autowired
    IStudentService studentService;

    @GetMapping(value="/list")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping(value="/register")
    public Student saveStudent(@Valid @RequestBody Student newStudent){
        return studentService.save(newStudent);
    }

    @DeleteMapping(value="/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
            studentService.deleteStudent(studentId);
    }

    @GetMapping(value="/get/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @PutMapping(value="/update/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId,@Valid @RequestBody Student s){
        return studentService.updateStudent(s,studentId);

    }

    @GetMapping(value="/studentList")
    public StudentList getStudentList(){
        List<Student> students= studentService.getAllStudents();
        StudentList studentList=new StudentList();
        studentList.setStudents(students);
        return studentList;
    }

}
