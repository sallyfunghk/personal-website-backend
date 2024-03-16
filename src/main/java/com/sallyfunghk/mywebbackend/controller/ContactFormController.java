package com.sallyfunghk.mywebbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.sallyfunghk.mywebbackend.entity.ContactForm;
import com.sallyfunghk.mywebbackend.service.ContactFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/contact_forms")
public class ContactFormController {
    private ContactFormService contactFormService;

    // Build create ContactForm REST API
    // POST http://{host_name}/api/contact_forms
    @PostMapping
    public ResponseEntity<ContactForm> createContactForm(@Valid @RequestBody ContactForm contactForm){

        ContactForm savedContactForm = contactFormService.createContactForm(contactForm);
        return new ResponseEntity<>(savedContactForm, HttpStatus.CREATED);
    }

    // Build Get All ContactForms REST API
    // GET http://{host_name}/api/contact_forms
    @GetMapping
    public ResponseEntity<List<ContactForm>> getAllContactForms(){
        List<ContactForm> contactForms = contactFormService.getAllContactForms();
        return new ResponseEntity<>(contactForms, HttpStatus.OK);
    }

    // Build Delete ContactForm REST API
    // DELETE http://{host_name}/api/contact_forms/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContactForm(@PathVariable("id") Long contactFormId){
        contactFormService.deleteContactForm(contactFormId);
        return new ResponseEntity<>("ContactForm deleted.", HttpStatus.OK);
    }

    // Handle validation exception by self defined message
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}