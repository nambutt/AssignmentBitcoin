package com.example.assignment.model;

import jakarta.persistence.*;

import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "bitcoin")
public class Bitcoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String disclaimer;
    @NonNull
    private String chartname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_time_id", referencedColumnName = "time_id")
    private Time time;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bitcoin_id", referencedColumnName = "id")
    private List<BitcoinPriceIndex> bitcoinPriceIndices;

    public void setId (Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return this.id;
    }

    public void setDisclaimer(String disclaimer)
    {
        this.disclaimer = disclaimer;
    }

    public void setChartname(String chartname)
    {
        this.chartname = chartname;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setBitcoinPriceIndices(List<BitcoinPriceIndex> bitcoinPriceIndexList)
    {
        this.bitcoinPriceIndices = bitcoinPriceIndexList;
    }

    public String getDisclaimer()
    {
        return this.disclaimer;
    }
    public String getChartname()
    {
        return this.chartname;
    }
    public List<BitcoinPriceIndex> getBitcoinPriceIndices()
    {
        return this.bitcoinPriceIndices;
    }
    public Time getTime()
    {
        return this.time;
    }
}
