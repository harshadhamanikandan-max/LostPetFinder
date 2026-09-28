package com.lostpetfinder.repository;

import com.lostpetfinder.entity.PetReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetReportRepository extends JpaRepository<PetReport, Long> {

    List<PetReport> findBySpeciesAndColourAndLocality(
            String species,
            String colour,
            String locality
    );
}