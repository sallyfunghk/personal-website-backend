package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}