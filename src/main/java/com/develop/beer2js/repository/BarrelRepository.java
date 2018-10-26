package com.develop.beer2js.repository;

import com.develop.beer2js.model.Barrel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrelRepository extends JpaRepository<Barrel, Long> {
    Page<Barrel> findByVarietyId(Long varietyId, Pageable pageable);
}
