package com.example.pixels_app.services;

import com.example.pixels_app.models.about_company.AboutCompany;
import com.example.pixels_app.repository.AboutCompanyRepository;
import com.example.pixels_app.utils.CacheUtil;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class AboutCompanyService {
    private final AboutCompanyRepository aboutCompanyRepository;

    public AboutCompanyService(AboutCompanyRepository aboutCompanyRepository) {
        this.aboutCompanyRepository = aboutCompanyRepository;
    }

    @CacheEvict(cacheNames = CacheUtil.ABOUT_COMPANY_CACHE, allEntries = true)
    public void setAboutMe(AboutCompany aboutMe) {
        aboutCompanyRepository.save(aboutMe);
    }

    @Cacheable(cacheNames = CacheUtil.ABOUT_COMPANY_CACHE)
    public AboutCompany getAboutMeEntity() {
        return aboutCompanyRepository.findById(1)
                .orElseThrow(() -> new RuntimeException(AboutCompany.ABOUT_ME_LOAD_ERROR));
    }

}