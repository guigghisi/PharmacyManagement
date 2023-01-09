package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.dto.UsuarioDto;
import com.devinhouse.pharmacymanagement.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //TODO REMOVER DPS
    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> consulta() {
        var usuarios = usuarioService.buscarTodos();
        var usuarioDto = new UsuarioDto();
        return usuarioDto.transformarEmListaDeDtos(usuarios);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto cadastraUsuario(@RequestBody UsuarioDto usuarioDto) {
        var usuario = usuarioDto.trasnformarEmEntidade();
        var usuarioSalvo = usuarioService.criarNoVoUsuario(usuario);

        return usuarioDto.transformarEmDto(usuarioSalvo);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.FOUND)
    public Long consultaUsuario(@RequestBody UsuarioDto usuarioDto) {
        var usuario = usuarioDto.trasnformarEmEntidade();
        return usuarioService.buscaUsuario(usuario);
    }
}
