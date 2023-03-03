package com.example.triviadto.controller;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.PreguntaResponseDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.service.service.JuegoService;
import com.example.triviadto.service.service.UsuarioService;
//import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/juego")
@CrossOrigin("*")
public class TriviaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    public UsuarioService getUsuarioService(){
        return this.usuarioService;
    }



    @Autowired
    private JuegoService juegoService;

    @Autowired
    public void setJuegoService(JuegoService juegoService){
        this.juegoService = juegoService;
    }
    public JuegoService getJuegoService(){
        return this.juegoService;
    }

    /**
     * Devuelve todos los usuarios de la base de datos
     * http://localhost:8080/api/juego/usuarios
     * @return List<Usuario>
     */
    @GetMapping("/usuarios")
   // @Operation(description = "Listar todos los usuarios de la base de datos")
    public List<Usuario> listarTodasLosUsuarios(){
        return usuarioService.listarUsuarios();

    }

    /**
     * Buscar un usuario por su id
     * http://localhost:8080/api/juego/usuarios/1
     * @param id
     * @return Usuario
     */
    @GetMapping("/usuarios/{id}")
  //  @Operation(description = "Buscar un usuario por su id")
    public ResponseEntity<UsuarioResponseDto> verUsuario(@PathVariable("id") Long id){
        return usuarioService.verUsuario(id);
    }


    /**
     * Recibo un usuario y lo guardo en la base de datos
     * http://localhost:8080/api/juego/registro
     * @param usuarioRequestDto
     * @return Usuario
     */
    @PostMapping("/registro")
   // @Operation(description = "Recibir un usuario y guardarlo en la base de datos")
    public Usuario crearUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto){
        return juegoService.guardarUsuarioJuego(usuarioRequestDto);
    }


    /**
     * Envia las cinco preguntas del juego
     * http://localhost:8080/api/juego/preguntas
     * @return ArrayList<Pregunta>
     */
    @GetMapping("/preguntas")
   // @Operation(description = "Enviar las preguntas del juego")
    public ArrayList<PreguntaResponseDto> enviarPreguntas(){
        return juegoService.listarPreguntas();
    }

    @GetMapping("/prueba")
    public String prueba() {
        return "Hola esto es una prueba";
    }
}

