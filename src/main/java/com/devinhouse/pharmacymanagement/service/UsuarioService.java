package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.entity.Usuario;
import com.devinhouse.pharmacymanagement.entity.dto.UsuarioDto;
import com.devinhouse.pharmacymanagement.exception.UsuarioDuplicadoException;
import com.devinhouse.pharmacymanagement.exception.UsuarioOuSenhaException;
import com.devinhouse.pharmacymanagement.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario criarNoVoUsuario(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()) != null) {
            throw new UsuarioDuplicadoException();
        }
        return repository.save(usuario);
    }

    public UsuarioDto buscaUsuario(Usuario usuario) {
        var usuarioBanco = repository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
        if (usuarioBanco != null) {
            return UsuarioDto.retornarId(usuarioBanco);
        }
        throw new UsuarioOuSenhaException();
    }
}
