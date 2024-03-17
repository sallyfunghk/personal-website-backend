package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}