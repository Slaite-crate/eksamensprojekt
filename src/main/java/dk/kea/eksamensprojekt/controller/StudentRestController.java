package dk.kea.eksamensprojekt.controller;

import dk.kea.eksamensprojekt.model.Student;
import dk.kea.eksamensprojekt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/api/student", consumes = {"application/json"})
    public ResponseEntity<String> create(@RequestBody Student student){
        studentRepository.save(student);
        return ResponseEntity.status(201).header("Location", "/api/student/" + student.getId()).body("{'message': 'post created'}");
    }

    @GetMapping("/api/student")
    public Iterable<Student> readAll(){
        return studentRepository.findAll();
    }

    @PutMapping("/api/student/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Student student){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()){
            return ResponseEntity.status(404).body("{'message': 'not found'}");
        }
        studentRepository.save(student);
        return ResponseEntity.status(200).body("{'message': 'updated'}");
    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()){
            return ResponseEntity.status(404).body("{'message': 'not found'}");
        }
        studentRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'message': 'deleted}");
    }
}
