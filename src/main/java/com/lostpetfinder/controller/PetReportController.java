package com.lostpetfinder.controller;

import com.lostpetfinder.entity.PetReport;
import com.lostpetfinder.service.PetReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetReportController {

    private final PetReportService service;

    public PetReportController(PetReportService service) {
        this.service = service;
    }

    @PostMapping
    public PetReport createReport(@RequestBody PetReport report) {
        return service.createReport(report);
    }

    @GetMapping
    public List<PetReport> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public PetReport getReportById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @PutMapping("/{id}")
    public PetReport updateReport(
            @PathVariable Long id,
            @RequestBody PetReport report) {
        return service.updateReport(id, report);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        service.deleteReport(id);
        return "Report deleted successfully";
    }

    @GetMapping("/{id}/matches")
    public List<PetReport> findMatches(@PathVariable Long id) {
        return service.findMatches(id);
    }
}