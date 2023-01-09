package com.devinhouse.pharmacymanagement.service;

import com.devinhouse.pharmacymanagement.entity.Usuario;
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

    public Long buscaUsuario(Usuario usuario) {
        if (repository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha()) != null) {
            //TODO retornar em JSON
            return usuario.getId();
        }
        throw new UsuarioOuSenhaException();
    }
}
