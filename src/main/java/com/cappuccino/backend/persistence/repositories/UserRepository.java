package com.cappuccino.backend.persistence.repositories;

import com.cappuccino.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krime on 1/16/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
