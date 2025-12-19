package kz.iitu.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "todo_items")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title must not be blank")
    @Size(max = 120, message = "title max length is 120")
    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false)
    private boolean completed;
}
