package com.mk.testAssignment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sector {

    @Id
//    @GeneratedValue(generator = "sector_seq", strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private Integer parentId;
    private Byte selectLevel;

    public Sector() {
    }

    public Sector(Integer id, String title, Integer parentId, Byte selectLevel) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.selectLevel = selectLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getSelectLevel() {
        return selectLevel;
    }

    public void setSelectLevel(Byte selectLevel) {
        this.selectLevel = selectLevel;
    }

}
