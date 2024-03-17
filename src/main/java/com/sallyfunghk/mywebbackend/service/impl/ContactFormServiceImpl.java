package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.ContactForm;
import com.sallyfunghk.mywebbackend.repository.ContactFormRepository;
import com.sallyfunghk.mywebbackend.service.ContactFormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactFormServiceImpl implements ContactFormService {

    private ContactFormRepository contactFormRepository;

    @Override
    public ContactForm createContactForm(ContactForm contactForm) {
        return contactFormRepository.save(contactForm);
    }

    @Override
    public List<ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }

    @Override
    public void deleteContactForm(Long contactFormId) {
        contactFormRepository.deleteById(contactFormId);
    }
}