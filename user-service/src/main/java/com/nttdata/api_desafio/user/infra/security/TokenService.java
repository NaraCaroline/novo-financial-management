//package com.nttdata.api_desafio.user.infra.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.nttdata.api_desafio.user.domain.User;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TokenService {
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public String generateToken(User user) {
//        try {
//            var algorithm = Algorithm.HMAC256(secret);
//            return JWT.create()
//                    .withIssuer("API Gestão Financeira")
//                    .withSubject(user.getUsername())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception) {
//            throw new RuntimeException("Erro ao gerar token JWT ", exception);
//        }
//    }
//
//    public String getSubject(String tokenJWT){
//        try {
//            var algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("API Gestão Financeira")
//                    .build()
//                    .verify(tokenJWT)
//                    .getSubject();
//        } catch (JWTVerificationException exception){
//            throw new RuntimeException("Token JWT inválido ou expirado.");
//        }
//    }
//}
