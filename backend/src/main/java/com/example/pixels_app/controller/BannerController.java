package com.example.pixels_app.controller;

import com.example.pixels_app.exception.annotations.AuthorizeAdmin;
import com.example.pixels_app.models.Banner;
import com.example.pixels_app.services.BannerServices;
import com.example.pixels_app.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
@RestController
@RequestMapping("api/v1/banners")
public class BannerController {

    private final BannerServices bannerServices;

    public BannerController(BannerServices bannerServices) {
        this.bannerServices = bannerServices;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> getAllBanners(HttpServletRequest request) {
        try {
            List<Banner> banners = bannerServices.getAllBanners();
            return new ResponseEntity<>(Response.createBody("banners", banners), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> addNewBanner(@Valid @RequestBody Banner banner) {
        try {
            bannerServices.addNewBanner(banner);
            return new ResponseEntity<>(Response.createBody("message", Banner.BANNER_ADDED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete/{name}", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> deleteBannerByNameOrID(@PathVariable("name") String bannerName) {
        try {
            String errorMessage = bannerServices.deleteBannerByNameOrID(bannerName);

            if (errorMessage == null ) {
                return new ResponseEntity<>(Response.createBody("message", Banner.BANNER_DELETED_SUCCESSFULLY), HttpStatus.OK);
            }

            return Response.errorMessage(Banner.BANNER_NOT_FOUND, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> updateBanner(@Valid @RequestBody Banner banner, @PathVariable("id") int id) {
        try {

            banner.setId(id);
            String errorMessage = bannerServices.updateBannerByID(banner);

            if (errorMessage == null ) {
                return new ResponseEntity<>(Response.createBody("message", Banner.BANNER_UPDATED_SUCCESSFULLY), HttpStatus.OK);
            }

            return Response.errorMessage(Banner.BANNER_NOT_FOUND, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update_many", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @AuthorizeAdmin
    public ResponseEntity<HashMap<String, Object>> updateBanner(@Valid @RequestBody Set<Banner> banners) {
        try {

            String errorMessage = null;
            for(Banner banner : banners) {
                errorMessage = bannerServices.updateBannerByID(banner);

                if (errorMessage != null) {
                    return Response .errorMessage(Banner.BANNER_NOT_FOUND, HttpStatus.NOT_ACCEPTABLE);
                }
            }
            return new ResponseEntity<>(Response.createBody("message", Banner.BANNER_UPDATED_SUCCESSFULLY), HttpStatus.OK);
        } catch (Exception e) {
            return Response.errorMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
