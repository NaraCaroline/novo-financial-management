package com.nttdata.api_desafio.user.adapters.controller;

import com.nttdata.api_desafio.user.domain.User;
import com.nttdata.api_desafio.user.dto.UserDto;
import com.nttdata.api_desafio.user.dto.UserSummaryDto;
import com.nttdata.api_desafio.user.dto.UserUpdateDto;
import com.nttdata.api_desafio.user.repositories.UserRepository;
import com.nttdata.api_desafio.user.services.UserImportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class
UserController {

    @Autowired
    private UserRepository repository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserImportService userImportService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDto data, UriComponentsBuilder uriBuilder) {
//    public ResponseEntity register(@RequestBody @Valid UserDto data, UriComponentsBuilder uriBuilder) {
        var user = new User(data);
        //user.encodePassword(passwordEncoder);
        repository.save(user);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/import")
    public ResponseEntity<String> importUsers(@RequestParam("file")
    MultipartFile file) {
        try {
            userImportService.importUsers(file);
            return ResponseEntity.ok("Usuários importados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao importar: " + e.getMessage());
        }
    }

    @PutMapping("/me")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserUpdateDto data, @AuthenticationPrincipal User currentUser) {
        currentUser.updateInfo(data);
        repository.save(currentUser);
        return ResponseEntity.ok(new UserSummaryDto(currentUser));
    }

    @DeleteMapping("/me")
    @Transactional
    public ResponseEntity delete(@AuthenticationPrincipal User currentUser) {
        repository.delete(currentUser);
        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }
}
