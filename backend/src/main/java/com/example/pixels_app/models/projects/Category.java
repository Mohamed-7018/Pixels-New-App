package com.example.pixels_app.models.projects;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    public static final String CATEGORY_NAME_ERROR = "'Category name' can't be empty";
    public static final String CATEGORY_ALREADY_EXIST = "Category already exists";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String CATEGORY_ADDED_SUCCESSFULLY = "Category added successfully";
    public static final String CATEGORY_DELETED_SUCCESSFULLY = "Category deleted successfully";
    public static final String CATEGORY_UPDATED_SUCCESSFULLY = "Category updated successfully";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "category", unique = true, nullable = false)
    @NotBlank(message = CATEGORY_NAME_ERROR)
    private String category;

    @Column(name = "image")
    private String image;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

}