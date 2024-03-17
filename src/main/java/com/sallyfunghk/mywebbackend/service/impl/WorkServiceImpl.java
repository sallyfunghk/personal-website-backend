package com.sallyfunghk.mywebbackend.service.impl;

import com.sallyfunghk.mywebbackend.entity.Work;
import com.sallyfunghk.mywebbackend.repository.WorkRepository;
import com.sallyfunghk.mywebbackend.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkServiceImpl implements WorkService {
    private WorkRepository workRepository;

    @Override
    public Work createWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Work getWorkById(Long workId) {

        Optional<Work> optionalUser = workRepository.findById(workId);
        return optionalUser.get();
    }

    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    public Work updateWork(Work work) {
        Work existingWork = workRepository.findById(work.getId()).get();

        existingWork.setStartMonth(work.getStartMonth());
        existingWork.setStartYear(work.getStartYear());
        existingWork.setEndMonth(work.getEndMonth());
        existingWork.setEndYear(work.getEndYear());
        existingWork.setTitle(work.getTitle());
        existingWork.setCompanyName(work.getCompanyName());
        existingWork.setProjects(work.getProjects());
        existingWork.setResponsibilities(work.getResponsibilities());
        existingWork.setTechSkills(work.getTechSkills());

        Work updatedWork = workRepository.save(existingWork);
        return updatedWork;
    }

    @Override
    public void deleteWork(Long workId) {
        workRepository.deleteById(workId);
    }
}