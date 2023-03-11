package com.devinhouse.pharmacymanagement.security;


import com.devinhouse.pharmacymanagement.context.ApplicationContextLoad;
import com.devinhouse.pharmacymanagement.entity.Usuario;
import com.devinhouse.pharmacymanagement.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service
@Component
public class JwtTokenAutenticacaoService {

    private static final long expiracao = 24 * 60 * 60 * 2;

    private  static final String senhaForte = "SENHA";

    private static final String tokenPrefixo = "Bearer";

    private static final String cabecalho = "Authorization";

    public void addAutenticacao(HttpServletResponse response, String username) throws IOException {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+expiracao))
                .signWith(SignatureAlgorithm.HS256, senhaForte).compact();
        String token = tokenPrefixo+ " " + JWT;
        response.getWriter().write("{\"Authorization\": \""+token+"\"}");
    }

    public Authentication buscarAutenticacao(HttpServletRequest request) {
        String token = request.getHeader(cabecalho);

        if (token != null) {
            String user = Jwts.parser().setSigningKey(senhaForte)
                    .parseClaimsJws(token.replace(tokenPrefixo, ""))
                    .getBody().getSubject();

            if(user != null){
                Usuario usuario = ApplicationContextLoad.getApplicationContext()
                        .getBean(UsuarioRepository.class).findUserByEmail(user);
                System.out.println("Login do Usuário: "+usuario.getEmail());

                if(usuario!=null){
                    return new UsernamePasswordAuthenticationToken(
                            usuario.getEmail(),
                            usuario.getSenha(),
                            usuario.getAuthorities()
                    );
                }
            }
        }
        return null;
    }

}
