package com.sallyfunghk.mywebbackend.repository;

import com.sallyfunghk.mywebbackend.entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {

}