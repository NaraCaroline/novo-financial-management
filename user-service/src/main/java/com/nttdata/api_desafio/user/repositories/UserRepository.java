package com.nttdata.api_desafio.user.repositories;

import com.nttdata.api_desafio.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    //UserDetails findByUsername(String username);
}
