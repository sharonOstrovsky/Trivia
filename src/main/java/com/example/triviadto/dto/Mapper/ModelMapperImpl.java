package com.example.triviadto.dto.Mapper;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperImpl implements ModelMapperInterface{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Usuario usuarioReqDtoAUsuario(UsuarioRequestDto usuarioRequestDto) {
        return modelMapper.map(usuarioRequestDto,Usuario.class);
    }

    @Override
    public UsuarioResponseDto usuarioAUsuarioResDto(Usuario usuario) {
        return modelMapper.map(usuario,UsuarioResponseDto.class);
    }
}
