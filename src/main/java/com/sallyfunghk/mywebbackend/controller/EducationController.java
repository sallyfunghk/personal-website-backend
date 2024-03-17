package com.sallyfunghk.mywebbackend.controller;

import com.sallyfunghk.mywebbackend.entity.Education;
import com.sallyfunghk.mywebbackend.service.EducationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/educations")
public class EducationController {
    private EducationService educationService;

    @PostMapping
    public ResponseEntity<Education> createEducation(@Valid @RequestBody Education education) {
        Education savedEducation = educationService.createEducation(education);
        return new ResponseEntity<>(savedEducation, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") Long educationId) {
        Education education = educationService.getEducationById(educationId);

        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = educationService.getAllEducations();

        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable("id") Long educationId, @RequestBody @Valid Education education) {
        education.setId(educationId);
        Education updatedEducation = educationService.updateEducation(education);

        return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEducation(@PathVariable("id") Long educationId) {
        educationService.deleteEducation(educationId);

        return new ResponseEntity<>("Education deleted", HttpStatus.OK);
    }
}