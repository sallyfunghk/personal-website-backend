package com.sallyfunghk.mywebbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "contact_forms")
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "name is required")
    private String name;

    @Column(nullable = false)
    @Email(message = "email is invalid")
    @NotBlank(message = "email is required")
    private String email;

    @Column
    private String phone_num;

    @Column
    private String company_name;

    @Column(nullable = false)
    @NotBlank(message = "content is required")
    private String content;
}