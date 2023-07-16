package com.example.triviadto.repository;

import com.example.triviadto.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    /*
    @Query(value = "SELECT * FROM pregunta ORDER BY RAND() LIMIT 20", nativeQuery = true)
    ArrayList<Question> getQuestionsTwoPlayers();

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.lastName = :lastName AND p.active=true")
    Person findByNameAndLastName(@Param("name") String name, @Param("lastName") String lastName);
     */

    @Query(value = "SELECT p FROM Pregunta p WHERE p.nivel = :nivel")
    ArrayList<Pregunta> obtenerPreguntasPorNivel(@Param("nivel") int nivel);

    @Query(value = "SELECT * FROM pregunta ORDER BY RAND() LIMIT 5", nativeQuery = true)
    ArrayList<Pregunta> obtenerPreguntas();


}
