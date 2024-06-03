package com.lautadev.microservice_benefit.Throwable;

import com.lautadev.microservice_benefit.model.Benefit;
import org.springframework.stereotype.Component;

@Component
public class BenefitValidator {

    public void saveValidate(Benefit benefit) {
        if (benefit == null) {
            throw new BenefitExceptions("Benefit cannot be null");
        }

        if (benefit.getName() == null || benefit.getName().isEmpty()) {
            throw new BenefitExceptions("Benefit name cannot be null or empty");
        }

    }
}
