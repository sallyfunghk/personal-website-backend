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

    @Column(nullable = false, name = "name")
    @NotBlank(message = "name is required")
    private String name;

    @Column(nullable = false, name = "organisation_name")
    @NotBlank(message = "organisation_name is required")
    private String organisation_name;
}