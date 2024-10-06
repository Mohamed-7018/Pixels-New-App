package com.example.pixels_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "certificates")
public class Certificate {
    public static final String CERTIFICATE_NOT_FOUND_ERROR = "certificate with given 'name' not found.";
    public static final String CERTIFICATE_NAME_ERROR = "certificate 'name' should be between 1-15 characters.";
    public static final String CERTIFICATE_IMAGE_ERROR = "certificate 'image' can't be empty";
    public static final String CERTIFICATE_LINK_ERROR = "certificate 'link' can't be empty";
    public static final String CERTIFICATE_ALREADY_EXISTS_ERROR = "certificate already exists.";
    public static final String CERTIFICATE_ADDED_SUCCESSFULLY = "certificate added successfully.";
    public static final String CERTIFICATE_UPDATED_SUCCESSFULLY = "certificate updated successfully.";
    public static final String CERTIFICATE_DELETED_SUCCESSFULLY = "certificate deleted successfully.";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank(message = CERTIFICATE_NAME_ERROR)
    private String name;

    @Column(name = "image", columnDefinition = "TEXT")
    @NotBlank(message = CERTIFICATE_IMAGE_ERROR)
    private String image;


    @Column(name = "link", columnDefinition = "TEXT")
    @NotBlank(message = CERTIFICATE_IMAGE_ERROR)
    private String link;

}

