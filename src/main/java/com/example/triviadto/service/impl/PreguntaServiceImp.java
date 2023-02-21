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
        List<Pregunta> preguntas = preguntaRepository.findAll();

        ArrayList<Pregunta> preguntasUsuario = new ArrayList<>();

        for (Pregunta pregunta: preguntas) {
            if(pregunta.getNivel() == nivel){
                preguntasUsuario.add(pregunta);
            }
        }

        return preguntasUsuario;
    }

    @Override
    public ArrayList<Pregunta> settearPreguntasParaUsuarioNivelNulo() {

        return (ArrayList<Pregunta>) preguntaRepository.findAll();

    }

    public ArrayList<Pregunta> obtenerPreguntasPorCategoria(ArrayList<Pregunta> preguntasUsuario, Categoria categoria){
        ArrayList<Pregunta> preguntasCategoria = new ArrayList<>();
       // System.out.println("Categoria: "+categoria);
        for (Pregunta pregunta: preguntasUsuario) {
            if(pregunta.getCategoria().equals(categoria)){
                preguntasCategoria.add(pregunta);

            }
        }

        return preguntasCategoria;
    }

}
