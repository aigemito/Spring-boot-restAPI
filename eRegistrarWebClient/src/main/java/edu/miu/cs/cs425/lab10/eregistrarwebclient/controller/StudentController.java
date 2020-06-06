package edu.miu.cs.cs425.lab10.eregistrarwebclient.controller;

import edu.miu.cs.cs425.lab10.eregistrarwebclient.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebclient.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping(value="/students")
    public ModelAndView getStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("student/students");
        return modelAndView;
    }

    @GetMapping(value="/student/new")
    public String getStudentForm(Model model){
        model.addAttribute("student",new Student());
        return "student/studentForm";
    }

    @PostMapping(value="/student/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student newStudent, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("error",result.getAllErrors());
           result.getAllErrors().stream().forEach(System.out::println);
            return "student/studentForm";
        }
        System.out.println("not suppose to be here");
        studentService.save(newStudent);
        return "redirect:/students";
    }

    @GetMapping(value="/student/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId, Model model){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping(value="/student/edit/{studentId}")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        Student student=studentService.findStudentById(studentId);
        if(student !=null){
            model.addAttribute("student",student);
            return "student/studentForm";
        }
        return "student/students";
    }


}
