package com.mk.testAssignment.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Sector sector;
    @NotNull
    private Byte agreeToTerms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAgreeToTerms() {
        return agreeToTerms;
    }

    public void setAgreeToTerms(Byte agreeToTerms) {
        this.agreeToTerms = agreeToTerms;
    }
}
