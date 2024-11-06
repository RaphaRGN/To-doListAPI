package com.raphaelprojetos.todo.services;

import com.raphaelprojetos.todo.models.Todo;
import com.raphaelprojetos.todo.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService (TodoRepository todoRepository){

        this.todoRepository = todoRepository;

    }

    public List<Todo> create(Todo todo){

        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        //Faz a listagem baseado na prioridade (Decresente) e no nome (Crescente)

        Sort sort = Sort.by("prioridade").descending().and(Sort.by("titulo").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){

        todoRepository.save(todo);
        return list();

    }

    public List<Todo> delete (Long id){

        todoRepository.deleteById(id);
        return list();

    }
}
