package com.adllo.proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario creator;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

    private LocalDateTime createAt;

    public void addComment(Comment comment){
        this.comment.add(comment);
        comment.setTopic(this);
    }

}
