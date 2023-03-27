package com.unitproject.Unit.Project.Spring.Base.repositories;

import com.unitproject.Unit.Project.Spring.Base.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer c WHERE c.cust_email = :custEmail", nativeQuery = true)
    Optional<Customer> getByEmail(String custEmail);
}
