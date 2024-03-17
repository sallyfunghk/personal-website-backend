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
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "start_month")
    @NotBlank(message = "startMonth is required")
    private String startMonth;

    @Column(nullable = false, name = "start_year")
    @NotBlank(message = "startYear is required")
    private String startYear;

    @Column(nullable = false, name = "end_month")
    @NotBlank(message = "endMonth is required")
    private String endMonth;

    @Column(nullable = false, name = "end_year")
    @NotBlank(message = "endYear is required")
    private String endYear;

    @Column(nullable = false, name = "title")
    @NotBlank(message = "title is required")
    private String title;

    @Column(name = "company_name")
    private String companyName;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "responsibilities", joinColumns = @JoinColumn(name = "work_id"))
    @Column(name = "responsibility")
    private List<String> responsibilities = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "projects", joinColumns = @JoinColumn(name = "work_id"))
    @Column(name = "project")
    private List<String> projects = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tech_skills", joinColumns = @JoinColumn(name = "work_id"))
    @Column(name = "tech_skill")
    private List<String> techSkills = new ArrayList<>();
}