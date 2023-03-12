package com.devinhouse.pharmacymanagement.repository;

import com.devinhouse.pharmacymanagement.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByEmailAndSenha(String email, String senha);
    @Query("select u from Usuario u where u.email = ?1")
    Usuario findUserByEmail(String email);
}
