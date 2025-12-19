package kz.iitu.todo.repo;

import kz.iitu.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {}
