package com.cappuccino.backend.persistence.repositories;

import com.cappuccino.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krime on 1/16/17.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
