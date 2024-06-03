package com.lautadev.microservice_benefit.service;

import com.lautadev.microservice_benefit.Throwable.BenefitExceptions;
import com.lautadev.microservice_benefit.Throwable.BenefitValidator;
import com.lautadev.microservice_benefit.model.Benefit;
import com.lautadev.microservice_benefit.repository.IBenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitService implements IBenefitService{
    @Autowired
    private IBenefitRepository benefitRepo;

    @Autowired
    private BenefitValidator validator;

    @Override
    public void saveBenefit(Benefit benefit) {
        validator.saveValidate(benefit);
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
    public void deleteBenefit(Long id) {
        benefitRepo.deleteById(id);
    }

    @Override
    public void editBenefit(Long id, Benefit benefit) {
        Benefit benefitEdit = this.findBenefit(id);

        benefitEdit.setName(benefit.getName());
        benefitEdit.setStartTime(benefit.getStartTime());
        benefitEdit.setEndTime(benefit.getEndTime());
        benefitEdit.setDay(benefit.getDay());
        benefitEdit.setTickets(benefit.getTickets());

        this.saveBenefit(benefitEdit);
    }
}
