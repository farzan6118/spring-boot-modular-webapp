package com.project.one.repository;

import com.project.one.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Customer> findByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);
}
