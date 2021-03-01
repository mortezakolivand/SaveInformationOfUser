package com.mk.testAssignment.dto;

import java.io.Serializable;

public class SectorDTO implements Serializable {

    private Integer id;
    private String title;
    private Integer parentId;
    private Byte selectLevel;

    public SectorDTO() {
    }

    public SectorDTO(Integer id, String title, Integer parentId, Byte selectLevel) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getSelectLevel() {
        return selectLevel;
    }

    public void setSelectLevel(Byte selectLevel) {
        this.selectLevel = selectLevel;
    }

}
