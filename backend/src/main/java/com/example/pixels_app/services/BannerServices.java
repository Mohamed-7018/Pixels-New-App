package com.example.pixels_app.services;

import com.example.pixels_app.models.Banner;
import com.example.pixels_app.repository.BannerRepository;
import com.example.pixels_app.utils.CacheUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerServices {
    private final BannerRepository bannerRepository;

    public BannerServices(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }


    @Cacheable(cacheNames = CacheUtil.BANNER_CACHE)
    public List<Banner> getAllBanners() {
        return bannerRepository.findAll();
    }

    @CacheEvict(cacheNames = CacheUtil.BANNER_CACHE, allEntries = true)
    public void addNewBanner(Banner banner) {
        bannerRepository.save(banner);
    }

    @CacheEvict(cacheNames = CacheUtil.BANNER_CACHE, allEntries = true)
    public String deleteBannerByNameOrID(String title) {
        Optional<Banner> existingBanner = bannerRepository.findBannerByName(title);

        if (existingBanner.isPresent()) {
            bannerRepository.delete(existingBanner.get());
            return null;
        }
        existingBanner = bannerRepository.findBannerByID(title);
        if (existingBanner.isPresent()) {
            bannerRepository.delete(existingBanner.get());
            return null;
        }
        return Banner.BANNER_NOT_FOUND;

    }


    @CacheEvict(cacheNames = CacheUtil.BANNER_CACHE, allEntries = true)
    public String updateBannerByID(Banner banner) {
        Optional<Banner> existingBanner = bannerRepository.findBannerByID(banner.getId().toString());

        if (existingBanner.isEmpty()) {
            return Banner.BANNER_NOT_FOUND;
        }
        bannerRepository.save(banner);
        return null;
    }

}
