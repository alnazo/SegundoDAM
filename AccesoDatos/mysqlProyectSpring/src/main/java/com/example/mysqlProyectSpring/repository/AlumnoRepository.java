package com.example.mysqlProyectSpring.repository;

import com.example.mysqlProyectSpring.model.Alumno;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
