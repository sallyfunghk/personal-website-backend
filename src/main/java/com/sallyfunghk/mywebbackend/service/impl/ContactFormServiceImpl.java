package com.sallyfunghk.mywebbackend.service.impl;

import lombok.AllArgsConstructor;
import com.sallyfunghk.mywebbackend.entity.ContactForm;
import com.sallyfunghk.mywebbackend.repository.ContactFormRepository;
import com.sallyfunghk.mywebbackend.service.ContactFormService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactFormServiceImpl implements ContactFormService {

    private ContactFormRepository ContactFormRepository;

    @Override
    public ContactForm createContactForm(ContactForm ContactForm) {
        return ContactFormRepository.save(ContactForm);
    }

    @Override
    public List<ContactForm> getAllContactForms() {
        return ContactFormRepository.findAll();
    }

    @Override
    public void deleteContactForm(Long ContactFormId) {
        ContactFormRepository.deleteById(ContactFormId);
    }
}