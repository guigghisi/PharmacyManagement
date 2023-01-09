package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Usuario;
import com.devinhouse.pharmacymanagement.exception.NenhumUsuarioException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    private String email;
    private String senha;

    public Usuario trasnformarEmEntidade() {
        var usuario = new Usuario();

        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);

        return usuario;
    }

    public UsuarioDto transformarEmDto(Usuario usuarioSalvo) {
        var usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuarioSalvo.getId());
        usuarioDto.setEmail(usuarioSalvo.getEmail());
        usuarioDto.setSenha(usuarioSalvo.getSenha());
        return usuarioDto;
    }

    public List<UsuarioDto> transformarEmListaDeDtos(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            throw new NenhumUsuarioException();
        }
        return usuarios.stream().map(this::transformarEmDto).collect(Collectors.toList());
    }
}
