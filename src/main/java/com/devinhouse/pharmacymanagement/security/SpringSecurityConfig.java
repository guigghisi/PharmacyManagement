package com.devinhouse.pharmacymanagement.security;


import com.devinhouse.pharmacymanagement.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .authorizeRequests()

                .antMatchers("/auth/**")

                .permitAll()

                .antMatchers(HttpMethod.GET,"/medicamento/**").hasAnyRole("GERENTE","ADMINISTRADOR","COLABORADOR")
                .antMatchers(HttpMethod.POST,"/medicamento/**").hasAnyRole("GERENTE","ADMINISTRADOR","COLABORADOR")
                .antMatchers(HttpMethod.PUT,"/medicamento/**").hasAnyRole("GERENTE","ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/medicamento/**").hasRole("ADMINISTRADOR")

                .antMatchers(HttpMethod.GET,"/farmacia/**").hasAnyRole("GERENTE","ADMINISTRADOR","COLABORADOR")
                .antMatchers(HttpMethod.POST,"/farmacia/**").hasAnyRole("GERENTE","ADMINISTRADOR","COLABORADOR")
                .antMatchers(HttpMethod.PUT,"/farmacia/**").hasAnyRole("GERENTE","ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/farmacia/**").hasRole("ADMINISTRADOR")

                .anyRequest()
                .authenticated()

                .and()

                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtLoginFilter("/auth", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


}
