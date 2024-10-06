package com.example.pixels_app.services;


import com.example.pixels_app.models.Certificate;
import com.example.pixels_app.repository.CertificateRepository;
import com.example.pixels_app.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateServices {
    @Autowired
    private CertificateRepository certificateRepository;


    @CacheEvict(cacheNames = CacheUtil.CERTIFICATE_CACHE,allEntries = true)
    public String addNewCertificate (Certificate certificate) {
        Optional<Certificate> existingClient = certificateRepository.findCertificateByName(certificate.getName());

        if (existingClient.isPresent()) {
            return Certificate.CERTIFICATE_ALREADY_EXISTS_ERROR;
        }

        // If the client does not exist, save the new client
        certificateRepository.save(certificate);
        return null;
    }

    @Cacheable(cacheNames = CacheUtil.CERTIFICATE_CACHE)
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @CacheEvict(cacheNames = CacheUtil.CERTIFICATE_CACHE,allEntries = true)
    public String deleteCertificateByNameOrID(String certificateName) {
        Optional<Certificate> existingCertificate = certificateRepository.findCertificateByName(certificateName);

        if (existingCertificate.isPresent()) {
            certificateRepository.delete(existingCertificate.get());
            return null;
        }
        existingCertificate = certificateRepository.findCertificateByID(certificateName);
        if (existingCertificate.isPresent()) {
            certificateRepository.delete(existingCertificate.get());
            return null;
        }
        // If the client does not exist, save the new client
        return Certificate.CERTIFICATE_NOT_FOUND_ERROR;

    }

    @CacheEvict(cacheNames = CacheUtil.CERTIFICATE_CACHE,allEntries = true)
    public String updateCertificateById(Certificate certificate) {
        Optional<Certificate> existingClient = certificateRepository.findCertificateByID(certificate.getId().toString());

        if (existingClient.isEmpty()) {
            return  Certificate.CERTIFICATE_NOT_FOUND_ERROR;
        }
        certificateRepository.save(certificate);
        return null;
    }
}
