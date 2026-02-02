//package com.nttdata.api_desafio.transaction.infra.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserClient {
//
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public String getUsernameFromToken(String token) {
//        try {
//            var algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("API Gestão Financeira")
//                    .build()
//                    .verify(token)
//                    .getSubject();
//        } catch (Exception e) {
//            throw new RuntimeException("Token JWT inválido: " + e.getMessage());
//        }
//    }
//}
