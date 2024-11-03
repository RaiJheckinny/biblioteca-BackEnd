package com.library.repository;

import com.library.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail (String nome);
}
