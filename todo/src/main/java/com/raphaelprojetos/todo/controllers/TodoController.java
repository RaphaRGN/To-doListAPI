package com.raphaelprojetos.todo.controllers;

import com.raphaelprojetos.todo.models.Todo;
import com.raphaelprojetos.todo.services.TodoService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TodoController {

   private TodoService todoService;

   public TodoController  (TodoService todoService){

         this.todoService = todoService;

   }

   @GetMapping
   public List<Todo> list (Todo todo){

      return todoService.list();

   }

   @PostMapping
   public List<Todo> create (Todo todo){

      return todoService.create(todo);

   }

   @DeleteMapping("{id}")
   public List<Todo> delete (@PathVariable("id")long id) {

      return todoService.delete(id);
   }
}
