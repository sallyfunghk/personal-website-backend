package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}