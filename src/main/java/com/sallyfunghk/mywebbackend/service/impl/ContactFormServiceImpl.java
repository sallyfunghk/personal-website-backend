package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.ContactForm;
import com.sallyfunghk.mywebbackend.repository.ContactFormRepository;
import com.sallyfunghk.mywebbackend.service.ContactFormService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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