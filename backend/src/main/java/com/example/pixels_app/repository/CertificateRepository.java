package com.example.pixels_app.repository;

import com.example.pixels_app.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    @Query(value = "SELECT * FROM certificates WHERE name = :name ORDER BY name ASC", nativeQuery = true)
    Optional<Certificate> findCertificateByName(@Param("name") String name);

    @Query(value = "SELECT * FROM certificates WHERE id = :id ORDER BY name ASC", nativeQuery = true)
    Optional<Certificate> findCertificateByID(@Param("id") String id);
}
