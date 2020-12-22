package dk.kea.eksamensprojekt.repository;

import dk.kea.eksamensprojekt.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
