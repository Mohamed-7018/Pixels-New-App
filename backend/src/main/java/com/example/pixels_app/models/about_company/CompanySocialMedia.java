package com.example.pixels_app.models.about_company;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company_social_media")
public class CompanySocialMedia {

    @Id
    @Column(name = "id")
    private Integer id = 1;

    @JsonProperty("facebook")
    @Column(name = "facebook", columnDefinition = "TEXT")
    private String facebook;

    @JsonProperty("instagram")
    @Column(name = "instagram", columnDefinition = "TEXT")
    private String instagram;

    @JsonProperty("linkedin")
    @Column(name = "linkedin", columnDefinition = "TEXT")
    private String linkedIn;

    @JsonProperty("youtube")
    @Column(name = "youtube", columnDefinition = "TEXT")
    private String youtube;

    @JsonProperty("x")
    @Column(name = "x", columnDefinition = "TEXT")
    private String x;
}