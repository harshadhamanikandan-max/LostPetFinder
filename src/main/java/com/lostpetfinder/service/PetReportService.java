package com.lostpetfinder.service;

import com.lostpetfinder.entity.PetReport;
import com.lostpetfinder.repository.PetReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetReportService {

    private final PetReportRepository repository;

    public PetReportService(PetReportRepository repository) {
        this.repository = repository;
    }

    public PetReport createReport(PetReport report) {
        return repository.save(report);
    }

    public List<PetReport> getAllReports() {
        return repository.findAll();
    }

    public PetReport getReportById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public PetReport updateReport(Long id, PetReport report) {

        PetReport existing = getReportById(id);

        existing.setReportType(report.getReportType());
        existing.setPetName(report.getPetName());
        existing.setSpecies(report.getSpecies());
        existing.setBreed(report.getBreed());
        existing.setColour(report.getColour());
        existing.setLocality(report.getLocality());
        existing.setDescription(report.getDescription());
        existing.setContactName(report.getContactName());
        existing.setContactPhone(report.getContactPhone());
        existing.setReportDate(report.getReportDate());
        existing.setStatus(report.getStatus());

        return repository.save(existing);
    }

    public void deleteReport(Long id) {
        repository.deleteById(id);
    }

    public List<PetReport> findMatches(Long id) {

        PetReport lostPet = getReportById(id);

        return repository.findBySpeciesAndColourAndLocality(
                lostPet.getSpecies(),
                lostPet.getColour(),
                lostPet.getLocality()
        );
    }
}