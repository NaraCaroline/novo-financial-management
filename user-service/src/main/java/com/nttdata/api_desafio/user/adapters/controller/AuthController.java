//package com.nttdata.api_desafio.user.adapters.controller;
//
//import com.nttdata.api_desafio.user.domain.User;
//import com.nttdata.api_desafio.user.dto.TokenJwtDto;
//import com.nttdata.api_desafio.user.dto.UserDto;
//import com.nttdata.api_desafio.user.infra.security.TokenService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class AuthController {
//    @Autowired
//    private AuthenticationManager manager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    public ResponseEntity userLogin(@RequestBody @Valid UserDto data) {
//        var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
//        var authentication = manager.authenticate(authenticationToken);
//        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
//        return ResponseEntity.ok(new TokenJwtDto(tokenJWT));
//    }
//}
