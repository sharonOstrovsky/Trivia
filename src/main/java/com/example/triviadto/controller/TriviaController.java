package com.example.triviadto.controller;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Pregunta;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.service.service.JuegoService;
import com.example.triviadto.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/juego")
public class TriviaController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JuegoService juegoService;

    @GetMapping("/usuarios")
    public List<Usuario> listarTodasLosUsuarios(){
        return usuarioService.listarUsuarios();

    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseDto> verUsuario(@PathVariable("id") Long id){
        return usuarioService.verUsuario(id);
    }

    @PostMapping("/registro")
    public Usuario crearUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto){
        return juegoService.guardarUsuarioJuego(usuarioRequestDto);
    }

    @GetMapping("/preguntas")
    public ArrayList<Pregunta> enviarPreguntas(Model modelo){
        return juegoService.listarPreguntas();
    }
}

