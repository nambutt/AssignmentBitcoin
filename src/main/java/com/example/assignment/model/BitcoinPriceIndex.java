package com.example.assignment.model;

import jakarta.persistence.*;
;
@Entity

@Table(name = "bitcoin-price-index")

public class BitcoinPriceIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bpi_id")
    private long id;

    private String code;
    private String symbol;
    private String rate;
    private String description;
    @Column(name = "rate_float")
    private float rateFloat;

    public void setCode(String code)
    {
        this.code = code;
    }
    public void setRate(String rate)
    {
        this.rate = rate;
    }
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setRateFloat(float rate)
    {
        this.rateFloat = rate;
    }
    public String getCode()
    {
        return this.code;
    }
    public String getRate()
    {
        return this.rate;
    }
    public String getSymbol()
    {
        return this.symbol;
    }
    public String getDescription()
    {
        return this.description;
    }
    public float getRateFloat()
    {
        return this.rateFloat;
    }
}
