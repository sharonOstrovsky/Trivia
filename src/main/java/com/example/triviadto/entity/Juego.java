package com.example.triviadto.entity;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Juego {

    private ArrayList<Pregunta> preguntas;
    private Usuario usuario;
    private int cantPreguntasPorUsuario; //5


}
