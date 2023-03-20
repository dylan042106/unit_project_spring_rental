package com.unitproject.Unit.Project.Spring.repositories;

import com.unitproject.Unit.Project.Spring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
