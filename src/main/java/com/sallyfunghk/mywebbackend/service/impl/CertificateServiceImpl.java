package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.Certificate;
import com.sallyfunghk.mywebbackend.repository.CertificateRepository;
import com.sallyfunghk.mywebbackend.service.CertificateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CertificateServiceImpl implements CertificateService {
    private CertificateRepository certificateRepository;

    @Override
    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificateById(Long certificateId) {

        Optional<Certificate> optionalUser = certificateRepository.findById(certificateId);
        return optionalUser.get();
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        Certificate existingCert = certificateRepository.findById(certificate.getId()).get();

        existingCert.setStartMonth(certificate.getStartMonth());
        existingCert.setStartYear(certificate.getStartYear());
        existingCert.setEndMonth(certificate.getEndMonth());
        existingCert.setEndYear(certificate.getEndYear());
        existingCert.setName(certificate.getName());
        existingCert.setOrganisationName(certificate.getOrganisationName());

        Certificate updatedCert = certificateRepository.save(existingCert);
        return updatedCert;
    }

    @Override
    public void deleteCertificate(Long certificateId) {
        certificateRepository.deleteById(certificateId);
    }
}