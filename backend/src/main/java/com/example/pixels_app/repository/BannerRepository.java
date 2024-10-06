package com.example.pixels_app.repository;


import com.example.pixels_app.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    @Query(value = "SELECT * FROM banners WHERE id = :id", nativeQuery = true)
    Optional<Banner> findBannerByID(@Param("id") String id);

    @Query(value = "SELECT * FROM banners WHERE title = :title", nativeQuery = true)
    Optional<Banner> findBannerByName(@Param("title") String title);

}
