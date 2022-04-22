package ma.enset.todolist.web;


import ma.enset.todolist.entities.Task;
import ma.enset.todolist.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepo taskRepo;


    //get all tasks
    @GetMapping(path = "tasks")
    public List<Task> getTasks() {
        System.out.println("whaaat" + taskRepo.findAll());
        return taskRepo.findAll();
    }


    /*get a task by id*/
    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    //add a new task
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {
        return taskRepo.save(newTask);
    }


    //update a task
    @PutMapping("/tasks/{id}")
    Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskRepo.findById(id)
                .map(task -> {
                    task.setDescription(newTask.getDescription());
                    return taskRepo.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return taskRepo.save(newTask);
                });
    }


    //delete a specific task
    @DeleteMapping(path = "/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }


}
