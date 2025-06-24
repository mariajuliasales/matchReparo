package com.mariajulia.matchreparo.repository;

import com.mariajulia.matchreparo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
