package com.devinhouse.pharmacymanagement.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O email não pode estar vazio")
    private String email;
    @NotEmpty(message = "A senha não pode estar vazia")
    private String senha;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "role_id"}, name = "unique_role_usuario"),
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
                    foreignKey = @ForeignKey(name = "fk_usuario", value = ConstraintMode.CONSTRAINT)),

            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", updatable = false,
                    foreignKey = @ForeignKey(name = "fk_role", value = ConstraintMode.CONSTRAINT)))
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
