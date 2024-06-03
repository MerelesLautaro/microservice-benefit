package com.lautadev.microservice_benefit.service;

import com.lautadev.microservice_benefit.model.Benefit;

import java.util.List;

public interface IBenefitService {
    public void saveBenefit(Benefit benefit);
    public List<Benefit> getBenefits();
    public Benefit findBenefit(Long id);
    public void deleteBenefit(Long id);
    public void editBenefit(Long id, Benefit benefit);
}
