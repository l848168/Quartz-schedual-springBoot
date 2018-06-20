package com.zjs.del.model.dto;

import java.io.Serializable;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:19
 * @Description:标准四级地址
 */
public class StandardAreaDTO implements Serializable {

    /**
     * 原地址
     */
    private String address;
    /**
     * 四级地址ID
     */
    private Long addressid;
    /**
     * 地址简称
     */
    private String shortname;
    /**
     * 地址名称
     */
    private String areaname;
    /**
     * 四级地址
     */
    private String fullname;
    /**
     * 四级地址级数
     */
    private Long level;
    /** 区号 */
    private String areacode;
    /**
     * 省ID
     */
    private Long provinceId;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 省级数
     */
    private Long provinceLv;
    /**
     * 市ID
     */
    private Long cityId;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 市级数
     */
    private Long cityLv;
    /**
     * 区ID
     */
    private Long districtId;
    /**
     * 区名称
     */
    private String districtName;
    /**
     * 区级数
     */
    private Long districtLv;
    /**
     * 乡/县
     */
    private Long countyId;
    /**
     * 乡/县 名称
     */
    private String countyName;
    /**
     * 乡/县级数
     */
    private Long countyLv;
    /**
     * 街道ID
     */
    private Long steetId;
    /**
     * 街道名称
     */
    private String streetName;
    /**
     * 街道级数
     */
    private Long streetLv;
    /**
     * 社区ID
     */
    private Long communityId;
    /**
     * 社区名称
     */
    private String communityName;
    /**
     * 社区级数
     */
    private Long communityLv;

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getProvinceLv() {
        return provinceLv;
    }

    public void setProvinceLv(Long provinceLv) {
        this.provinceLv = provinceLv;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityLv() {
        return cityLv;
    }

    public void setCityLv(Long cityLv) {
        this.cityLv = cityLv;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getDistrictLv() {
        return districtLv;
    }

    public void setDistrictLv(Long districtLv) {
        this.districtLv = districtLv;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Long getCountyLv() {
        return countyLv;
    }

    public void setCountyLv(Long countyLv) {
        this.countyLv = countyLv;
    }

    public Long getSteetId() {
        return steetId;
    }

    public void setSteetId(Long steetId) {
        this.steetId = steetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getStreetLv() {
        return streetLv;
    }

    public void setStreetLv(Long streetLv) {
        this.streetLv = streetLv;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Long getCommunityLv() {
        return communityLv;
    }

    public void setCommunityLv(Long communityLv) {
        this.communityLv = communityLv;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
}
