package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}