package com.mk.testAssignment.dto;

import com.mk.testAssignment.domain.Sector;

import javax.persistence.ManyToOne;
import java.io.Serializable;


public class UserDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer sectorId;
    private Boolean agreeToTerms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAgreeToTerms() {
        return agreeToTerms==null?Boolean.FALSE:agreeToTerms;
    }

    public void setAgreeToTerms(Boolean agreeToTerms) {
        this.agreeToTerms = agreeToTerms;
    }
}
