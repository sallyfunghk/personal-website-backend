package com.sallyfunghk.mywebbackend.service;

import com.sallyfunghk.mywebbackend.entity.Certification;

import java.util.List;

public interface CertificationService {
    Certification createCertification(Certification certification);

    Certification getCertificationById(Long certificationId);

    List<Certification> getAllCertifications();

    Certification updateCertification(Certification certification);

    void deleteCertification(Long certificationId);
}