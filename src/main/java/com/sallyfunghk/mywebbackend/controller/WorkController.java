package com.sallyfunghk.mywebbackend.controller;

import com.sallyfunghk.mywebbackend.entity.Work;
import com.sallyfunghk.mywebbackend.service.WorkService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/works")
public class WorkController {
    private WorkService workService;

    @PostMapping
    public ResponseEntity<Work> createWork(@Valid @RequestBody Work work) {
        Work savedWork = workService.createWork(work);
        return new ResponseEntity<>(savedWork, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Work> getWorkById(@PathVariable("id") Long workId) {
        Work work = workService.getWorkById(workId);

        return new ResponseEntity<>(work, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Work>> getAllWorks() {
        List<Work> works = workService.getAllWorks();

        return new ResponseEntity<>(works, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Work> updateWork(@PathVariable("id") Long workId, @RequestBody @Valid Work work) {
        work.setId(workId);
        Work updatedWork = workService.updateWork(work);

        return new ResponseEntity<>(updatedWork, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWork(@PathVariable("id") Long workId) {
        workService.deleteWork(workId);

        return new ResponseEntity<>("Work deleted", HttpStatus.OK);
    }
}