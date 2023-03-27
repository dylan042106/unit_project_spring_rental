package com.unitproject.Unit.Project.Spring.Base.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cust_id;
    String cust_email;
    String cust_password;
    String cust_name;

    public Customer() {
    }

    public Customer(Long cust_id, String cust_email, String cust_password, String cust_name) {
        this.cust_id = cust_id;
        this.cust_email = cust_email;
        this.cust_password = cust_password;
        this.cust_name = cust_name;
    }

    public Customer(String cust_email, String cust_password, String cust_name) {
        this.cust_email = cust_email;
        this.cust_password = cust_password;
        this.cust_name = cust_name;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getCust_password() {
        return cust_password;
    }

    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
}
