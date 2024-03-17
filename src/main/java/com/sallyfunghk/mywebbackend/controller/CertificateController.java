package com.sallyfunghk.mywebbackend.controller;

import com.sallyfunghk.mywebbackend.entity.Certificate;
import com.sallyfunghk.mywebbackend.service.CertificateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/certificates")
public class CertificateController {
    private CertificateService certificateService;

    @PostMapping
    public ResponseEntity<Certificate> createCertificate(@Valid @RequestBody Certificate certificate) {
        Certificate savedCertificate = certificateService.createCertificate(certificate);
        return new ResponseEntity<>(savedCertificate, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable("id") Long certificateId) {
        Certificate certificate = certificateService.getCertificateById(certificateId);

        return new ResponseEntity<>(certificate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        List<Certificate> certificates = certificateService.getAllCertificates();

        return new ResponseEntity<>(certificates, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable("id") Long certificateId, @RequestBody @Valid Certificate certificate) {
        certificate.setId(certificateId);
        Certificate updatedCertificate = certificateService.updateCertificate(certificate);

        return new ResponseEntity<>(updatedCertificate, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCertificate(@PathVariable("id") Long certificateId) {
        certificateService.deleteCertificate(certificateId);

        return new ResponseEntity<>("Certificate deleted", HttpStatus.OK);
    }
}