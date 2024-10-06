package com.example.pixels_app.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.pixels_app.exception.annotations.AuthorizeAdmin;
import com.example.pixels_app.models.about_company.AboutCompany;
import com.example.pixels_app.services.AboutCompanyService;
import com.example.pixels_app.utils.Response;

import java.util.HashMap;


@Tag(name = "About Company", description = "About Company data Endpoint")
@Controller
@RestController
@RequestMapping("api/v1")
public class AboutCompanyController {

    private final AboutCompanyService aboutCompanyService;

    public AboutCompanyController(AboutCompanyService aboutCompanyService) {
        this.aboutCompanyService = aboutCompanyService;
    }

    @Operation(summary = "Update the about copany data", security = {
			@SecurityRequirement(name = "api_key", scopes = { "write:about", "read:about" }) }, tags = { "About Company" })
    @PutMapping(path = "/about", consumes = "application/json", produces = "application/json")
    @AuthorizeAdmin
    @CrossOrigin
    public ResponseEntity<HashMap<String, Object>> setAboutMe(@Valid @RequestBody AboutCompany aboutCompany) {
        try {
            aboutCompanyService.setAboutMe(aboutCompany);
            return new ResponseEntity<>(Response.createBody("message", AboutCompany.ABOUT_COMPANY_UPDATED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(path = "/about", produces = "application/json")
    @AuthorizeAdmin
    @CrossOrigin
    public ResponseEntity<HashMap<String, Object>> getAboutMe(HttpServletRequest request) {
        try{
            HashMap<String, Object> responseBody = Response.createBody(
                    new String[]{"body"},
                    new Object[]{aboutCompanyService.getAboutMeEntity()}
            );
            return new ResponseEntity<>(
                    responseBody,
                    HttpStatus.OK);
        }catch (Exception e){
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


