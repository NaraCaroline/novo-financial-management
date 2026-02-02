//package com.nttdata.api_desafio.transaction.infra.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//    @Autowired
//    private UserClient userClient;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        var tokenJWT = retrieveToken(request);
//
//        if (tokenJWT != null) {
//            try {
//                var username = userClient.getUsernameFromToken(tokenJWT);
//                var authentication = new UsernamePasswordAuthenticationToken(
//                        username,
//                        null,
//                        Collections.emptyList()
//                );
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } catch (Exception e) {
//                System.err.println("Token inválido: " + e.getMessage());
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String retrieveToken(HttpServletRequest request) {
//        var authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            return authorizationHeader.replace("Bearer ", "");
//        }
//        return null;
//    }
//}
