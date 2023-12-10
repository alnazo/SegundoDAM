package com.adllo.proyecto.repository;

import com.adllo.proyecto.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByTituloContainingIgnoreCase(String f);

    List<Topic> findAllByOrderByCreateAtDesc();

}
