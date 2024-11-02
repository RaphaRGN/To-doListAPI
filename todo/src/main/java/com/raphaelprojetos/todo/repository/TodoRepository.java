package com.raphaelprojetos.todo.repository;

import com.raphaelprojetos.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Long> {

}
