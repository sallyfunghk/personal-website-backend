package com.sallyfunghk.mywebbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certifications")
public class Certification {

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

    @Column(nullable = false, name = "name")
    @NotBlank(message = "name is required")
    private String name;

    @Column(nullable = false, name = "organisation_name")
    @NotBlank(message = "organisationName is required")
    private String organisationName;
}