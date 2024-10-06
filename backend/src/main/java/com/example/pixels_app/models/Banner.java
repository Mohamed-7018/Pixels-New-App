package com.example.pixels_app.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banners")
public class Banner {

    public static final String BANNER_TITLE_ERROR = "Banner 'title' can't be empty";
    public  static final String BANNER_DESCRIPTION_ERROR = "Banner 'description' can't be empty";
    public static final String BANNER_IMAGE_ERROR = "Banner 'image' can't be empty";


    public static final String BANNER_ADDED_SUCCESSFULLY = "Banner added successfully";
    public static final String BANNER_UPDATED_SUCCESSFULLY = "Banner updated successfully";
    public static final String BANNER_DELETED_SUCCESSFULLY  = "Banner deleted successfully";
    public static final String BANNER_NOT_FOUND  = "Banner not found";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private Integer id;

    @Column(name = "title" , unique = true, nullable = false)
    @NotBlank(message = BANNER_TITLE_ERROR)
    private String title;

    @Column (name = "description",nullable = false)
    @NotBlank(message = BANNER_DESCRIPTION_ERROR)
    private  String description;

    @Column(name = "image")
    @NotBlank(message = BANNER_IMAGE_ERROR)
    private String image;

}
