package com.example.triviadto.dto.Mapper;

import com.example.triviadto.dto.requestDto.UsuarioRequestDto;
import com.example.triviadto.dto.responseDto.UsuarioResponseDto;
import com.example.triviadto.entity.Usuario;

public interface ModelMapperInterface {

    Usuario usuarioReqDtoAUsuario(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto usuarioAUsuarioResDto(Usuario usuario);


}
