package com.sallyfunghk.mywebbackend.service;

import com.sallyfunghk.mywebbackend.entity.Certificate;

import java.util.List;

public interface CertificateService {
    Certificate createCertificate(Certificate certificate);

    Certificate getCertificateById(Long certificateId);

    List<Certificate> getAllCertificates();

    Certificate updateCertificate(Certificate certificate);

    void deleteCertificate(Long certificateId);
}