package com.sallyfunghk.mywebbackend.service;

import com.sallyfunghk.mywebbackend.entity.Education;

import java.util.List;

public interface EducationService {
    Education createEducation(Education education);

    Education getEducationById(Long educationId);

    List<Education> getAllEducations();

    Education updateEducation(Education education);

    void deleteEducation(Long educationId);
}