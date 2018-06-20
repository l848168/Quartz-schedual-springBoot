package com.zjs.del.model.entity;

import java.util.Objects;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:20
 * @Description:标准四级地址
 */
public class StandardArea {

    /**
     * 地址ID
     */
    private Long addressid;
    /**
     * 地址父ID
     */
    private Long parentid;
    /**
     * 地址简称
     */
    private String shortname;
    /**
     * 地址名称
     */
    private String areaname;
    /**
     * 地址省市区全称
     */
    private String fullname;
    /**
     * 地址级数
     */
    private Long level;
    /** 区号 */
    private String areacode;
    /**
     * 是否审核 (0:否；1：是)
     */
    private Integer isChecked = 0;

    /**
     * 时间戳
     */
    private String ts;
    /** 城市区域主键 */
    private String pkregion;
    /** 省市区简称 */
    private String fullShort;

    public String getFullShort() {
        return fullShort;
    }

    public void setFullShort(String fullShort) {
        this.fullShort = fullShort;
    }

    public String getPkregion() {
        return pkregion;
    }

    public void setPkregion(String pkregion) {
        this.pkregion = pkregion;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardArea stdArea = (StandardArea) o;
        return Objects.equals(addressid, stdArea.addressid) &&
                Objects.equals(parentid, stdArea.parentid) &&
                Objects.equals(shortname, stdArea.shortname) &&
                Objects.equals(areaname, stdArea.areaname) &&
                Objects.equals(fullname, stdArea.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressid, parentid, shortname, areaname, fullname);
    }
}
