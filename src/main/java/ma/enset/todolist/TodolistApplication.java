package ma.enset.todolist;

import ma.enset.todolist.entities.Task;
import ma.enset.todolist.repositories.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TaskRepo taskRepo){
        return  args ->{

            taskRepo.save(new Task("first task"));
            taskRepo.save(new Task("second task"));
            taskRepo.save(new Task("third task"));

            System.out.println("tasks saved");
        };
    }

}
