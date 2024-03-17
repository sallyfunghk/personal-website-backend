package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}