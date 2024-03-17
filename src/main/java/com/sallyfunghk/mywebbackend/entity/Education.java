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
@Table(name = "education")
public class Education {

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

    @Column(nullable = false, name = "certification")
    @NotBlank(message = "certification is required")
    private String certification;

    @Column(nullable = false, name = "school_name")
    @NotBlank(message = "school_name is required")
    private String school_name;
}