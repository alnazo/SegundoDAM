package com.adllo.proyecto.service;

import com.adllo.proyecto.dto.CommnetDTO;
import com.adllo.proyecto.model.Comment;
import com.adllo.proyecto.model.Topic;
import com.adllo.proyecto.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(CommnetDTO commnetDTO){
        Topic topic = topicService.findById(commnetDTO.getTopic().getId()).orElseThrow();

        Comment comment = new Comment();

        comment.setContenido(commnetDTO.getContenido());
        comment.setCreator(commnetDTO.getCreator());
        comment.setCreateAt(LocalDateTime.now());

        topic.addComment(comment);

        commentRepository.save(comment);

    }

}
