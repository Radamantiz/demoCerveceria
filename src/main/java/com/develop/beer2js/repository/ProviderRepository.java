package com.develop.beer2js.repository;

import com.develop.beer2js.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


//@CrossOrigin
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
