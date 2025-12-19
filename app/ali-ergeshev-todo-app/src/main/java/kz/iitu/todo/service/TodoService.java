package kz.iitu.todo.service;

import kz.iitu.todo.entity.TodoItem;
import kz.iitu.todo.exception.NotFoundException;
import kz.iitu.todo.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repo;

    public List<TodoItem> findAll() {
        return repo.findAll();
    }

    public TodoItem findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Todo not found: " + id));
    }

    public TodoItem create(TodoItem item) {
        item.setId(null);
        return repo.save(item);
    }

    public TodoItem update(Long id, TodoItem item) {
        TodoItem existing = findById(id);
        existing.setTitle(item.getTitle());
        existing.setCompleted(item.isCompleted());
        return repo.save(existing);
    }

    public void delete(Long id) {
        TodoItem existing = findById(id);
        repo.delete(existing);
    }
}
