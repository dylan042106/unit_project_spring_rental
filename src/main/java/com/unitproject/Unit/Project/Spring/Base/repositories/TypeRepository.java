package com.unitproject.Unit.Project.Spring.Base.repositories;

import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TypeRepository extends JpaRepository<VehicleType, Long> {
}
