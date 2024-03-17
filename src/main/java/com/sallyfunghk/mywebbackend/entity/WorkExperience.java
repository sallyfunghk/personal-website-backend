package com.sallyfunghk.mywebbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "start_month")
    @NotBlank(message = "start_month is required")
    private String start_month;

    @Column(nullable = false, name = "start_year")
    @NotBlank(message = "start_year is required")
    private String start_year;

    @Column(nullable = false, name = "end_month")
    @NotBlank(message = "end_month is required")
    private String end_month;

    @Column(nullable = false, name = "end_year")
    @NotBlank(message = "end_year is required")
    private String end_year;

    @Column(nullable = false, name = "title")
    @NotBlank(message = "title is required")
    private String title;

    @Column(name = "company_name")
    private String company_name;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "responsibilities", joinColumns = @JoinColumn(name = "work_exp_id"))
    @Column(name = "responsibility")
    private List<String> responsibilities = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "projects", joinColumns = @JoinColumn(name = "work_exp_id"))
    @Column(name = "project")
    private List<String> projects = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tech_skills", joinColumns = @JoinColumn(name = "work_exp_id"))
    @Column(name = "tech_skill")
    private List<String> tech_skills = new ArrayList<>();
}