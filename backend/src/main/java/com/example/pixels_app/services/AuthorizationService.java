package com.example.pixels_app.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private static String appPassword;

    @Value("${com.company_website.appPassword}")
    @SuppressWarnings("static-access")
    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    private AuthorizationService() {}

    public static boolean authorize(HttpServletRequest request) {
        if (request == null) {
            return false;
        }
        String password = request.getHeader("api_key");
        return (password != null && !password.isBlank() && password.equals(appPassword));
    }
}
