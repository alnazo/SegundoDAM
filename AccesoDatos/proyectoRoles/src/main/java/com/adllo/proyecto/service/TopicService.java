package com.adllo.proyecto.service;


import com.adllo.proyecto.dto.TopicDTO;
import com.adllo.proyecto.model.Comment;
import com.adllo.proyecto.model.Topic;
import com.adllo.proyecto.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> allTopics() {
        return topicRepository.findAllByOrderByCreateAtDesc();
    }

    public List<Topic> filterTopics(String filter){
        return topicRepository.findByTituloContainingIgnoreCase(filter);
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic createTopic(TopicDTO topic) {
        Topic newTopic = new Topic();

        newTopic.setTitulo(topic.getTitulo());
        newTopic.setContenido(topic.getContenido());
        newTopic.setCreator(topic.getCreator());
        newTopic.setCreateAt(LocalDateTime.now());

        return topicRepository.save(newTopic);
    }

}
