package com.sallyfunghk.mywebbackend.service;

import com.sallyfunghk.mywebbackend.entity.ContactForm;

import java.util.List;

public interface ContactFormService {
    ContactForm createContactForm(ContactForm contactForm);

    List<ContactForm> getAllContactForms();

    void deleteContactForm(Long formId);
}