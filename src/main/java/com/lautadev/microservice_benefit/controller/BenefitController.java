package com.lautadev.microservice_benefit.controller;

import com.lautadev.microservice_benefit.model.Benefit;
import com.lautadev.microservice_benefit.service.IBenefitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benefit")
public class BenefitController {
    @Autowired
    private IBenefitService beneServ;

    @PostMapping("/save")
    public ResponseEntity<?> saveBenefit(@Valid @RequestBody Benefit benefit){
        beneServ.saveBenefit(benefit);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Benefit>> getBenefits(){
        List<Benefit> listBenefits = beneServ.getBenefits();
        return ResponseEntity.ok(listBenefits);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Benefit> findBenefit(@PathVariable Long id) {
        Benefit benefit = beneServ.findBenefit(id);

        if (benefit == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(benefit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBenefit(@PathVariable Long id) {
        beneServ.deleteBenefit(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Benefit> editBenefit(@PathVariable Long id, @Valid @RequestBody Benefit benefit){
        beneServ.editBenefit(id,benefit);
        return ResponseEntity.ok(beneServ.findBenefit(benefit.getId()));
    }
}
