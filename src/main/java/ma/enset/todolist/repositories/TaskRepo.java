package ma.enset.todolist.repositories;

import ma.enset.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {



}
