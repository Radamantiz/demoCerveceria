package com.develop.beer2js.repository;

import com.develop.beer2js.model.SalePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePointRepository extends JpaRepository<SalePoint, Long> {
}
