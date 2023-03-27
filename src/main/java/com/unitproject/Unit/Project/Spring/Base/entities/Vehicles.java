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
    private String vehicle_year;
    private String mpg;
    private boolean is_rented = false;
    private String vehicle_ppd;

    public Vehicles() {
    }

    public Vehicles(Long vehicle_id, String vehicle_name, String vehicle_year, String mpg, Boolean is_rented, String vehicle_ppd) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.vehicle_ppd = vehicle_ppd;
        this.vehicle_year = vehicle_year;
        this.mpg = mpg;
        this.is_rented = is_rented;
    }

    public Vehicles(String vehicle_name, String vehicle_year, String mpg, Boolean is_rented, String vehicle_ppd) {
        this.vehicle_name = vehicle_name;
        this.vehicle_ppd = vehicle_ppd;
        this.vehicle_year = vehicle_year;
        this.mpg = mpg;
        this.is_rented = is_rented;
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

    public String getVehicle_ppd() {
        return vehicle_ppd;
    }

    public void setVehicle_ppd(String vehicle_ppd) {
        this.vehicle_ppd = vehicle_ppd;
    }

    public String getVehicle_year() {
        return vehicle_year;
    }

    public void setVehicle_year(String vehicle_year) {
        this.vehicle_year = vehicle_year;
    }

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public boolean isIs_rented() {
        return is_rented;
    }

    public void setIs_rented(boolean is_rented) {
        this.is_rented = is_rented;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void assignToType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
