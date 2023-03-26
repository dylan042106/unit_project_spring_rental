package com.unitproject.Unit.Project.Spring.Base.repositories;

import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
    @Query(value = "SELECT * FROM vehicles v WHERE v.type_id = :type_id", nativeQuery = true)
    List<Vehicles> getCertainType(Long type_id);
}
