package com.unitproject.Unit.Project.Spring.Base.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private VehicleType vehicleType;

    private String vehicle_name;
    private String vehicle_model;
    private String vehicle_ppd;

    public Vehicles() {
    }

    public Vehicles(Long vehicle_id, String vehicle_name, String vehicle_model, String vehicle_ppd) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.vehicle_model = vehicle_model;
        this.vehicle_ppd = vehicle_ppd;
    }

    public Vehicles(String vehicle_name, String vehicle_model, String vehicle_ppd) {
        this.vehicle_name = vehicle_name;
        this.vehicle_model = vehicle_model;
        this.vehicle_ppd = vehicle_ppd;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_ppd() {
        return vehicle_ppd;
    }

    public void setVehicle_ppd(String vehicle_ppd) {
        this.vehicle_ppd = vehicle_ppd;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void assignToType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
