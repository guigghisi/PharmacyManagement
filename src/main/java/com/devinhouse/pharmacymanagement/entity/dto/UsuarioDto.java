package com.devinhouse.pharmacymanagement.entity.dto;

import com.devinhouse.pharmacymanagement.entity.Usuario;
import com.devinhouse.pharmacymanagement.exception.NenhumUsuarioException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;

    public static UsuarioDto retornarId(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        return usuarioDto;
    }

    public Usuario transformarEmEntidade() {
        Usuario usuario = new Usuario();

        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);

        return usuario;
    }

    public UsuarioDto transformarEmDto(Usuario usuarioSalvo) {
        UsuarioDto usuarioDto = new UsuarioDto();
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
