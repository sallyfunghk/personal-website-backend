package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.Education;
import com.sallyfunghk.mywebbackend.repository.EducationRepository;
import com.sallyfunghk.mywebbackend.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {
    private EducationRepository educationRepository;

    @Override
    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education getEducationById(Long educationId) {

        Optional<Education> optionalUser = educationRepository.findById(educationId);
        return optionalUser.get();
    }

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Education updateEducation(Education education) {
        Education existingEducation = educationRepository.findById(education.getId()).get();

        existingEducation.setStartMonth(education.getStartMonth());
        existingEducation.setStartYear(education.getStartYear());
        existingEducation.setEndMonth(education.getEndMonth());
        existingEducation.setEndYear(education.getEndYear());
        existingEducation.setCertification(education.getCertification());
        existingEducation.setSchoolName(education.getSchoolName());

        Education updatedEducation = educationRepository.save(existingEducation);
        return updatedEducation;
    }

    @Override
    public void deleteEducation(Long educationId) {
        educationRepository.deleteById(educationId);
    }
}