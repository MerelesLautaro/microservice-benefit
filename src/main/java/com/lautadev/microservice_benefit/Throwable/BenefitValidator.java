package com.lautadev.microservice_benefit.Throwable;

import com.lautadev.microservice_benefit.model.Benefit;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BenefitValidator {

    private final Validator validator;

    public BenefitValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void validate(Benefit benefit) {
        if (benefit == null) {
            throw new BenefitExceptions("Benefit cannot be null");
        }

        // Validaciones estándar usando Hibernate Validator
        Set<ConstraintViolation<Benefit>> violations = validator.validate(benefit);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Benefit> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new BenefitExceptions(sb.toString());
        }

        // Validaciones personalizadas
        if (benefit.getStartTime().isAfter(benefit.getEndTime())) {
            throw new BenefitExceptions("Start time cannot be after end time");
        }
    }
}
