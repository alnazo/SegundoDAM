package com.adllo.proyecto.dto;

import com.adllo.proyecto.model.Comment;
import com.adllo.proyecto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class TopicDTO {

    private String titulo;
    private String contenido;
    private Usuario creator;
    private List<Comment> comment;
    private LocalDateTime createAt;

}
