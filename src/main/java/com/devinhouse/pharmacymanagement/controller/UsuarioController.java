package com.devinhouse.pharmacymanagement.controller;

import com.devinhouse.pharmacymanagement.entity.Usuario;
import com.devinhouse.pharmacymanagement.entity.dto.UsuarioDto;
import com.devinhouse.pharmacymanagement.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto consultaUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioDto.transformarEmEntidade();
        return usuarioService.buscaUsuario(usuario);
    }
}
