package com.raphaelprojetos.todo.controllers;

import com.raphaelprojetos.todo.models.Todo;
import com.raphaelprojetos.todo.services.TodoService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TodoController {

   private TodoService todoService;

   public TodoController(TodoService todoService) {

      this.todoService = todoService;

   }

   @GetMapping
   @ResponseBody
   public List<Todo> list(Todo todo) {

      return todoService.list();

   }

   @PostMapping
   @ResponseBody
   public List<Todo> create(@RequestBody Todo todo) {

      return todoService.create(todo);

   }

   @DeleteMapping("{id}")
   @ResponseBody
   public List<Todo> delete(@PathVariable("id") long id) {

      return todoService.delete(id);
   }

   @PutMapping("{id}")
   @ResponseBody
   public ResponseEntity<Todo> update(@PathVariable("id") Long id, @RequestBody Todo todo) {
      Todo updatedTodo = todoService.update(id, todo);
      return ResponseEntity.ok(updatedTodo);
   }

}

