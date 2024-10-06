package com.example.pixels_app.utils;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheUtil {
    public  static final String ABOUT_COMPANY_CACHE = "aboutCompanyCache";
    public  static final String ARTICLES_CACHE = "articlesCache";
    public  static final String CLIENT_CACHE = "clientsCache";
    public  static final String USER_CACHE = "userCache";

    public  static  final String BANNER_CACHE = "bannerCache";
    public static final  String PROJECT_CACHE ="projectCache";

    public static final String SKILL_CACHE ="skillCache";
    public static final String CERTIFICATE_CACHE ="certificateCache";
//    public static  final String FEATURE_CACHE ="featureCache";


    @Scheduled(fixedRate = 4, timeUnit = TimeUnit.HOURS)
    @CacheEvict(cacheNames = {ABOUT_COMPANY_CACHE, ARTICLES_CACHE, CLIENT_CACHE,USER_CACHE,BANNER_CACHE , PROJECT_CACHE , SKILL_CACHE, CERTIFICATE_CACHE }, allEntries = true)
    public void clearCache() {
        System.out.println("Cleared Cache at " + DateFormat.MMddyyyyhhmmss());

        // System.out.println(STR."Cleared Cache at \{DateFormat.MMddyyyyhhmmss()}");
    }
}

