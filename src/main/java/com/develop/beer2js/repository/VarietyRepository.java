package com.develop.beer2js.repository;


import com.develop.beer2js.model.Variety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VarietyRepository extends JpaRepository<Variety, Long> {
    List<Variety> findByProviderId(Long provider_id);
    List<Variety> findByColorId(Long color_id);
}
