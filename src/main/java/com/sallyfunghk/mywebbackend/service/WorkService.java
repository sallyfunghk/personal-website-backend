package com.sallyfunghk.mywebbackend.service;

import com.sallyfunghk.mywebbackend.entity.Work;

import java.util.List;

public interface WorkService {
    Work createWork(Work work);

    Work getWorkById(Long workId);

    List<Work> getAllWorks();

    Work updateWork(Work work);

    void deleteWork(Long workId);
}