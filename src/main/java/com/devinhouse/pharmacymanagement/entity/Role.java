package com.devinhouse.pharmacymanagement.entity;


import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;



@Entity
@Table(name="role")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
