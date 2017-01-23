package com.cappuccino.backend.service;

import com.cappuccino.backend.persistence.domain.backend.Plan;
import com.cappuccino.backend.persistence.repositories.PlanRepository;
import com.cappuccino.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by krime on 1/23/17.
 */
@Service
@Transactional(readOnly = true)
public class PlanService {

    @Autowired
    public PlanRepository planRepository;


    /**
     * Returns the plan id for the given id or null if it couldn't findone
     * @param planId The plan id
     * @return The plan id for the given id or null if it couldn't find one
     */
    public Plan findPlanById(int planId) {
        return planRepository.findOne(planId);
    }

    /**
     * It creates a Basic or Pro plan.
     * @param planId The plan id
     * @return the created Plan
     * @throws IllegalArgumentException if the plan id is not 1 or 2
     */
    @Transactional
    public Plan createPlan(int planId) {

        Plan plan = null;

        if (planId == 1) {
            plan = planRepository.save(new Plan(PlansEnum.BASIC));
        } else if (planId == 2) {
            plan = planRepository.save(new Plan(PlansEnum.PRO));
        } else {
            throw new IllegalArgumentException("Plan id " + planId + " not recognized");
        }
        return plan;
    }

}
