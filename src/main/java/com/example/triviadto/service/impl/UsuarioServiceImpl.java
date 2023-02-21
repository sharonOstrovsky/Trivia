package com.example.triviadto.service.impl;


import com.example.triviadto.dto.Mapper.ModelMapperInterface;
import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;
import com.example.triviadto.repository.UsuarioRepository;
import com.example.triviadto.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapperInterface modelMapperInterface;


    @Override
    public int obtenerNivelPorEdad(Usuario usuario) {

        if(usuario.getEdad() < 14){
            return 1;
        }else if (usuario.getEdad() >= 14 && usuario.getEdad() < 17 ) {
            return 2;
        } else if (usuario.getEdad() >= 17 ) {
            return 3;
        }
        return 0;
    }

    @Override
    public ResponseEntity<UsuarioResponseDto> verUsuario(Long id) {
        Usuario usuario = usuarioRepository.traer(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapperInterface.usuarioAUsuarioResDto(usuario));
    }


    @Override
    public Usuario crearUsuario(UsuarioRequestDto usuarioRequestDto) {

        Usuario usuario = modelMapperInterface.usuarioReqDtoAUsuario(usuarioRequestDto);

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
