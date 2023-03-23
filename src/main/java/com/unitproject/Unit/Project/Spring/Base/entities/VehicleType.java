package com.unitproject.Unit.Project.Spring.Base.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long type_id;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicleType")
    private Set<Vehicles> vehicles = new HashSet<>();
    private String type_name;

    public VehicleType(){
    }
    public VehicleType(Long type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Set<Vehicles> getVehicles() {
        return vehicles;
    }
}
