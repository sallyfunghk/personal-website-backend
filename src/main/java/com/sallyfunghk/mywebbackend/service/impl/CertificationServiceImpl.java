package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.Certification;
import com.sallyfunghk.mywebbackend.repository.CertificationRepository;
import com.sallyfunghk.mywebbackend.service.CertificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CertificationServiceImpl implements CertificationService {
    private CertificationRepository certificationRepository;

    @Override
    public Certification createCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public Certification getCertificationById(Long certificationId) {

        Optional<Certification> optionalUser = certificationRepository.findById(certificationId);
        return optionalUser.get();
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    @Override
    public Certification updateCertification(Certification certification) {
        Certification existingCert = certificationRepository.findById(certification.getId()).get();
        /*existingCert.setStart_month(certification.getStart_month());
        existingCert.setEnd_year();
        existingCert.setEnd_month(certification.getEnd_month());*/
        Certification updatedCert = certificationRepository.save(existingCert);
        return updatedCert;
    }

    @Override
    public void deleteCertification(Long certificationId) {
        certificationRepository.deleteById(certificationId);
    }
}