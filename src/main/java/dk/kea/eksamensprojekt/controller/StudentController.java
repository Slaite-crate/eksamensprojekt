package dk.kea.eksamensprojekt.controller;

import dk.kea.eksamensprojekt.model.Student;
import dk.kea.eksamensprojekt.repository.StudentRepository;
import dk.kea.eksamensprojekt.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;

    @PostMapping("/student/create")
    public String create(@ModelAttribute Student student){
        if (!student.getName().equals("")){
            if (!student.getEmail().equals("")){
                if (student.getSupervisor() !=null){
                    studentRepository.save(student);
                }
            }
        }
        return "redirect:/student";
    }

    @GetMapping("/student")
    public String readAll(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("supervisors", supervisorRepository.findAll());
        return "student";
    }

    @PostMapping("/student/update")
    public String update(@ModelAttribute Student student){
        if (!student.getName().equals("")){
            if (!student.getEmail().equals("")){
                if (student.getSupervisor() !=null){
                    studentRepository.save(student);
                }
            }
        }
        return "redirect:/student";
    }

    @GetMapping("/student/update")
    public String update(@RequestParam Long id, Model model){
        model.addAttribute("student", studentRepository.findById(id));
        model.addAttribute("supervisors", supervisorRepository.findAll());
        return "/update";
    }

    @GetMapping("/student/delete")
    public String delete(@RequestParam Long id){
        studentRepository.deleteById(id);
        return "redirect:/student";
    }
}
