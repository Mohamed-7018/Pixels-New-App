package com.example.pixels_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pixels_app.models.about_company.AboutCompany;


@Repository
public interface AboutCompanyRepository extends CrudRepository<AboutCompany,Integer> {
}
