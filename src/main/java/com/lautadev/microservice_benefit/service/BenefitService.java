package com.lautadev.microservice_benefit.service;

import com.lautadev.microservice_benefit.Throwable.BenefitExceptions;
import com.lautadev.microservice_benefit.Throwable.BenefitValidator;
import com.lautadev.microservice_benefit.model.Benefit;
import com.lautadev.microservice_benefit.repository.IBenefitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BenefitService implements IBenefitService{

    private final IBenefitRepository benefitRepo;
    private final BenefitValidator benefitValidator;

    @Autowired
    public BenefitService(IBenefitRepository benefitRepo, BenefitValidator benefitValidator){
        this.benefitRepo = benefitRepo;
        this.benefitValidator  = benefitValidator;
    }

    @Override
    @Transactional
    public void saveBenefit(Benefit benefit) {
        benefitValidator.validate(benefit);
        benefitRepo.save(benefit);
    }

    @Override
    public List<Benefit> getBenefits() {
        return benefitRepo.findAll();
    }

    @Override
    public Benefit findBenefit(Long id) {
        return benefitRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteBenefit(Long id) {
        benefitRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void editBenefit(Long id, Benefit benefit) {
        benefitValidator.validate(benefit);
        Benefit benefitEdit = this.findBenefit(id);
        BeanUtils.copyProperties(benefit, benefitEdit, "id");
        this.saveBenefit(benefitEdit);
    }
}
