package com.example.assignment.model;

import jakarta.persistence.*;

@Entity

@Table(name = "time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private Long id;

    private String updated;
    private String updatedISO;
    private String updateduk;

    public void setUpdated(String updated)
    {
        this.updated = updated;
    }
    public void setUpdatedISO(String updatedISO)
    {
        this.updatedISO = updatedISO;
    }
    public void setUpdateduk(String updateduk)
    {
        this.updateduk = updateduk;
    }

    public String getUpdated()
    {
        return this.updated;
    }
    public String getUpdateduk()
    {
        return this.updateduk;
    }
    public String getUpdatedISO()
    {
        return this.updatedISO;
    }
}
