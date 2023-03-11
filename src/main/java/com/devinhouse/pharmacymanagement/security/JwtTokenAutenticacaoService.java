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

    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 2;

    private  static final String SECRET = "SENHA";

    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    public void addAutenticacao(HttpServletResponse response, String username) throws IOException {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        String token = TOKEN_PREFIX + " " + JWT;
        response.getWriter().write("{\"Authorization\": \""+token+"\"}");
    }

    public Authentication buscarAutenticacao(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            String user = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
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
