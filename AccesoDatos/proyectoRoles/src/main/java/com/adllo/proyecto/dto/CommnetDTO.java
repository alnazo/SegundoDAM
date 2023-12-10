package com.adllo.proyecto.dto;

import com.adllo.proyecto.model.Topic;
import com.adllo.proyecto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class CommnetDTO {

    private String contenido;
    private Usuario creator;
    private Topic topic;
    private LocalDateTime createAt;

}
