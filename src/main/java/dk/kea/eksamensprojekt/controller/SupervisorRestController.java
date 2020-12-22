package dk.kea.eksamensprojekt.controller;

import dk.kea.eksamensprojekt.model.Supervisor;
import dk.kea.eksamensprojekt.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupervisorRestController {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @GetMapping("/supervisor")
    public Iterable<Supervisor> readAll(){
        return supervisorRepository.findAll();
    }
}
