package com.example.pixels_app.models.about_company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "about_company")
public class AboutCompany {
    public static final String ABOUT_ME_ABOUT_ERROR = "'about' can't be empty.";
    public static final String ABOUT_ME_COMPANY_NAME_ERROR = "'company_name' can't be empty.";
    public static final String ABOUT_ME_COMPANY_LOGO_ERROR = "'company_logo' can't be empty.";
    public static final String ABOUT_ME_VISION_ERROR = "'vision' can't be empty.";
    public static final String ABOUT_ME_MISSION_ERROR = "'mission' can't be empty.";
    public static final String ABOUT_ME_HISTORY_ERROR = "'history' can't be empty.";
    public static final String ABOUT_ME_SLOGAN_ERROR = "'slogan' can't be empty.";

    public static final String ABOUT_ME_LOAD_ERROR = "Error in loading About Me.";
    public static final String COMPANY_NAME_TEXT_ERROR = "'company name' should be between 1-100 characters.";
    public static final String ABOUT_COMPANY_UPDATED_SUCCESSFULLY = "About company updated successfully";


    @Id
    @Column(name = "id")
    private Integer id = 1;

    @JsonProperty("about")
    @Column(name = "about", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_ABOUT_ERROR)
    private String about;

    @JsonProperty("company_name")
    @Column(name = "company_name", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_COMPANY_NAME_ERROR)
    private String companyName;

    @JsonProperty("company_logo")
    @Column(name = "company_logo", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_COMPANY_LOGO_ERROR)
    private String companyLogo;

    @JsonProperty("vision")
    @Column(name = "vision", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_VISION_ERROR)
    private String vision;

    @Column(name = "history", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_HISTORY_ERROR)
    private String history;

    @JsonProperty("mission")
    @Column(name = "mission", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_MISSION_ERROR)
    private String mission;

    @JsonProperty("slogan")
    @Column(name = "slogan", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_SLOGAN_ERROR)
    private String slogan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts_id", referencedColumnName = "id")
    @JsonProperty("contacts")
    private CompanyContacts companyContacts;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("social_media")
    @JoinColumn(name = "social_media_id", referencedColumnName = "id")
    private CompanySocialMedia companySocialMedia;

}
