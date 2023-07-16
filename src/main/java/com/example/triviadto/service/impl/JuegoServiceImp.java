package com.example.triviadto.service.impl;


import com.example.triviadto.dto.Mapper.ModelMapperInterface;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.entity.Juego;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.repository.PreguntaRepository;
import com.example.triviadto.service.service.JuegoService;
import com.example.triviadto.service.service.PreguntaService;
import com.example.triviadto.service.service.UsuarioService;
import com.example.triviadto.utility.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class JuegoServiceImp implements JuegoService {

    Juego juego = new Juego();

    PreguntaService preguntaService;

    UsuarioService usuarioService;

   // @Autowired
    private ModelMapperInterface modelMapperInterface;
    private final PreguntaRepository preguntaRepository;

    public JuegoServiceImp(PreguntaService preguntaService, UsuarioService usuarioService,ModelMapperInterface modelMapperInterface,
                           PreguntaRepository preguntaRepository) {
        this.preguntaService = preguntaService;
        this.usuarioService = usuarioService;
        this.modelMapperInterface = modelMapperInterface;
        this.preguntaRepository = preguntaRepository;
    }


    public ArrayList<PreguntaResponseDto> listarPreguntas(){
        settearPreguntas();

        ArrayList<PreguntaResponseDto> preguntasDTO = new ArrayList<>();
        ArrayList<Pregunta> preguntas = preguntaRepository.obtenerPreguntas();


        for (Pregunta pregunta : preguntas) {
            preguntasDTO.add(modelMapperInterface.preguntaAPreguntaResDto(pregunta));
        }

        return preguntasDTO;
    }

    @Override
    public List<Pregunta> listarTodasLasPreguntas() {
        return preguntaRepository.findAll();
    }


    @Override
    public void settearPreguntas() {

        int nivel = usuarioService.obtenerNivelPorEdad(juego.getUsuario());
        if(nivel == 0){
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuarioNivelNulo());
        }else{
            juego.setPreguntas(preguntaService.settearPreguntasParaUsuario(nivel));
        }


    }

    @Override
    public Usuario guardarUsuarioJuego(UsuarioRequestDto usuarioRequestDto){
        Usuario usuario= usuarioService.crearUsuario(usuarioRequestDto);
        juego.setUsuario(usuario);
        return usuario;
    }




}
