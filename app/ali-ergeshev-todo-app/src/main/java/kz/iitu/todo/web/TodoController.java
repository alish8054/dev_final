package kz.iitu.todo.web;

import jakarta.validation.Valid;
import kz.iitu.todo.entity.TodoItem;
import kz.iitu.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public List<TodoItem> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TodoItem one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem create(@Valid @RequestBody TodoItem item) {
        return service.create(item);
    }

    @PutMapping("/{id}")
    public TodoItem update(@PathVariable Long id, @Valid @RequestBody TodoItem item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
