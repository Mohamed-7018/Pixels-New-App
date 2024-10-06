package com.example.pixels_app.controller;


import com.example.pixels_app.exception.annotations.AuthorizeAdmin;
import com.example.pixels_app.models.Certificate;
import com.example.pixels_app.services.CertificateServices;
import com.example.pixels_app.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@RequestMapping("api/v1/certificates")
public class CertificateController {

    @Autowired
    private CertificateServices certificateServices;

    @GetMapping(path = "/get", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> getAllCertificates(HttpServletRequest request) {
        try {
            List<Certificate> certificates = certificateServices.getAllCertificates();
            return new ResponseEntity<>(Response.createBody("body", certificates), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> addNewCertificate(@Valid @RequestBody Certificate certificate) {
        try {
            String errorMessage = certificateServices.addNewCertificate(certificate);
            if (errorMessage != null) {
                return Response.errorMessage(errorMessage, HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(Response.createBody("message", Certificate.CERTIFICATE_ADDED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(path = "/delete/{name}", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> deleteCertificateByNameOrID(HttpServletRequest request, @PathVariable("name") String clientName) {
        try {
            String errorMessage = certificateServices.deleteCertificateByNameOrID(clientName);
            if (errorMessage != null) {
                return Response.errorMessage(errorMessage, HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(Response.createBody("message", Certificate.CERTIFICATE_DELETED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(path = "/update/{id}", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> updateClientByID(@Valid @RequestBody Certificate certificate, @PathVariable("id") int id) {
        try {
            certificate.setId(id);
            String errorMessage = certificateServices.updateCertificateById(certificate);
            if (errorMessage != null) {
                return Response.errorMessage(errorMessage, HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(Response.createBody("message", Certificate.CERTIFICATE_UPDATED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update_many", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> updateClientByID(@Valid @RequestBody List<Certificate> certificates) {
        try {
            String errorMessage = null;
            for (Certificate certificate : certificates) {
                errorMessage = certificateServices.updateCertificateById(certificate);
                if (errorMessage != null) {
                    return Response.errorMessage(errorMessage, HttpStatus.NOT_ACCEPTABLE);
                }
            }

            return new ResponseEntity<>(Response.createBody("message", Certificate.CERTIFICATE_UPDATED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
