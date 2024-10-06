package com.example.pixels_app.models.projects;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {
    public static String PROJECT_ALREADY_EXISTS = "Project with the same name already exists";
    public static String PROJECT_NOT_FOND = "Project not found";
    public static String PROJECT_AlREADY_HAVE_THIS_FEATURE = "Project already have this feature";
    public static String PROJECT_DONT_HAVE_THIS_FEATURE = "Project don't have this feature";
    public static String PROJECT_UPDATED_SUCCESSFULLY = "Project updated successfully";
    public static String PROJECT_DELETED_SUCCESSFULLY = "Project deleted successfully";
    public static String PROJECT_CATEGORY_ADDED_SUCCESSFULLY = "Project added to the Category successfully";
    public static String PROJECT_CATEGORY_DELETED_SUCCESSFULLY = "Project deleted from the Category successfully";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name ="github")
    private String github;



}
