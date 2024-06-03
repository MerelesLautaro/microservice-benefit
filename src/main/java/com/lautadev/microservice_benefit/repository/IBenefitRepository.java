package com.lautadev.microservice_benefit.repository;

import com.lautadev.microservice_benefit.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBenefitRepository extends JpaRepository<Benefit, Long> {
}
