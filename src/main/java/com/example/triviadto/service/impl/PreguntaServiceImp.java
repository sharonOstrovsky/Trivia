package com.example.triviadto.service.impl;


import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.repository.PreguntaRepository;
import com.example.triviadto.service.service.PreguntaService;
import com.example.triviadto.utility.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PreguntaServiceImp implements PreguntaService {


    PreguntaRepository preguntaRepository;

    public PreguntaServiceImp(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuario(int nivel) {
        System.out.println("nivel: "+ nivel);
        return preguntaRepository.obtenerPreguntasPorNivel(nivel);

    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo() {

        return (ArrayList<Pregunta>) preguntaRepository.findAll();

    }


}
