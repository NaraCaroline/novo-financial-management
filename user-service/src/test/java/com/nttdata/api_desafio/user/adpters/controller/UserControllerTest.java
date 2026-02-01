package com.nttdata.api_desafio.user.adpters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.api_desafio.user.domain.User;
import com.nttdata.api_desafio.user.dto.UserDto;
import com.nttdata.api_desafio.user.repositories.UserRepository;
import com.nttdata.api_desafio.user.services.UserImportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private UserRepository repository;
    @MockitoBean
    private UserImportService importService;

    @Test
    @DisplayName("Cadastrar usuário com dados válidos")
    void testRegisterValidUser() throws Exception {
        UserDto dto = new UserDto("danielcarlos", "senha123");
        String json = objectMapper.writeValueAsString(dto);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());
        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Não cadastrar com username vazio")
    void testDontRegisterWithEmptyUsername() throws Exception {
        UserDto dto = new UserDto("", "senha123");
        String json = objectMapper.writeValueAsString(dto);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest());
        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("Não cadastrar com password vazio")
    void testDontRegisterWithEmptyPassword() throws Exception {
        UserDto dto = new UserDto("anajulia", "");
        String json = objectMapper.writeValueAsString(dto);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest());
        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("Deletar usuário logado")
    void testDeleteLoggedUser() throws Exception {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("testuser");
        mockUser.setPassword("password");

        mockMvc.perform(delete("/users/me").with(user(mockUser))).andExpect(status().isOk());
        verify(repository, times(1)).delete(any(User.class));
    }
}
