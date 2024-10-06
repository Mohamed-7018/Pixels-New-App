package com.example.pixels_app.models.about_company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "company_contacts")
public class CompanyContacts {
    public static final String ABOUT_ME_PHONE_ERROR = "'phone' can't be empty.";
    public static final String ABOUT_ME_EMAIL_ERROR = "'email' can't be empty.";
    public static final String ABOUT_ME_ADDRESS_ERROR = "'address' can't be empty.";
    public static final String ABOUT_ME_ADDRESS_LINK_ERROR = "'address_link' can't be empty.";

    @Id
    @Column(name = "id")
    private Integer id = 1;

    @JsonProperty("phone")
    @Column(name = "phone", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_PHONE_ERROR)
    private String phone;

    @JsonProperty("email")
    @Column(name = "email", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_EMAIL_ERROR)
    private String email;

    @JsonProperty("address")
    @Column(name = "address", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_ADDRESS_ERROR)
    private String address;

    @JsonProperty("address_link")
    @Column(name = "address_link", columnDefinition = "TEXT")
    @NotBlank(message = ABOUT_ME_ADDRESS_LINK_ERROR)
    private String addressLink;
}