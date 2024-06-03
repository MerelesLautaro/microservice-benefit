package com.lautadev.microservice_benefit.controller;

import com.lautadev.microservice_benefit.model.Benefit;
import com.lautadev.microservice_benefit.service.IBenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/benefit")
public class BenefitController {
    @Autowired
    private IBenefitService beneServ;

    @PostMapping("/save")
    public ResponseEntity<?> saveBenefit(@RequestBody Benefit benefit){
        beneServ.saveBenefit(benefit);
        return ResponseEntity.ok().build();
    }
}
