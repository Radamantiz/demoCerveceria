package com.develop.beer2js.repository;

import com.develop.beer2js.model.Provider;
import com.develop.beer2js.model.Variety;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyRepository extends JpaRepository<Variety, Long> {
    Page<Variety> findByProviderId(Long providerId, Pageable pageable);
}
