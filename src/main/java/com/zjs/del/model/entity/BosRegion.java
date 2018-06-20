package com.zjs.del.model.entity;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:02
 * @Description:
 */
public class BosRegion {

    private String pkRegion;
    private String cparentid;
    private String bintl;
    private String vprov;
    private String vcity;
    private String vcounty;
    private String vpostcode;
    private String vcitycode;
    private String coutwcorp;
    private String cinwcorp;
    private Long fcitygrade;
    private String pkProv;
    private String pkCity;
    private Long ipubid;
    private String vbelongcity;
    private Long fzonerelation;
    private String pkPriceprovpart;
    /**省简称 */
    private String vshortprov;
    /**市简称 */
    private String vshortcity;
    /** 区简称 */
    private String vshortcounty;
    private String ts;
    private String dr;
    private String baseTs;

    public String getPkRegion() {
        return pkRegion;
    }

    public void setPkRegion(String pkRegion) {
        this.pkRegion = pkRegion;
    }

    public String getCparentid() {
        return cparentid;
    }

    public void setCparentid(String cparentid) {
        this.cparentid = cparentid;
    }

    public String getBintl() {
        return bintl;
    }

    public void setBintl(String bintl) {
        this.bintl = bintl;
    }

    public String getVprov() {
        return vprov;
    }

    public void setVprov(String vprov) {
        this.vprov = vprov;
    }

    public String getVcity() {
        return vcity;
    }

    public void setVcity(String vcity) {
        this.vcity = vcity;
    }

    public String getVcounty() {
        return vcounty;
    }

    public void setVcounty(String vcounty) {
        this.vcounty = vcounty;
    }

    public String getVpostcode() {
        return vpostcode;
    }

    public void setVpostcode(String vpostcode) {
        this.vpostcode = vpostcode;
    }

    public String getVcitycode() {
        return vcitycode;
    }

    public void setVcitycode(String vcitycode) {
        this.vcitycode = vcitycode;
    }

    public String getCoutwcorp() {
        return coutwcorp;
    }

    public void setCoutwcorp(String coutwcorp) {
        this.coutwcorp = coutwcorp;
    }

    public String getCinwcorp() {
        return cinwcorp;
    }

    public void setCinwcorp(String cinwcorp) {
        this.cinwcorp = cinwcorp;
    }

    public Long getFcitygrade() {
        return fcitygrade;
    }

    public void setFcitygrade(Long fcitygrade) {
        this.fcitygrade = fcitygrade;
    }

    public String getPkProv() {
        return pkProv;
    }

    public void setPkProv(String pkProv) {
        this.pkProv = pkProv;
    }

    public String getPkCity() {
        return pkCity;
    }

    public void setPkCity(String pkCity) {
        this.pkCity = pkCity;
    }

    public Long getIpubid() {
        return ipubid;
    }

    public void setIpubid(Long ipubid) {
        this.ipubid = ipubid;
    }

    public String getVbelongcity() {
        return vbelongcity;
    }

    public void setVbelongcity(String vbelongcity) {
        this.vbelongcity = vbelongcity;
    }

    public Long getFzonerelation() {
        return fzonerelation;
    }

    public void setFzonerelation(Long fzonerelation) {
        this.fzonerelation = fzonerelation;
    }

    public String getPkPriceprovpart() {
        return pkPriceprovpart;
    }

    public void setPkPriceprovpart(String pkPriceprovpart) {
        this.pkPriceprovpart = pkPriceprovpart;
    }

    public String getVshortprov() {
        return vshortprov;
    }

    public void setVshortprov(String vshortprov) {
        this.vshortprov = vshortprov;
    }

    public String getVshortcity() {
        return vshortcity;
    }

    public void setVshortcity(String vshortcity) {
        this.vshortcity = vshortcity;
    }

    public String getVshortcounty() {
        return vshortcounty;
    }

    public void setVshortcounty(String vshortcounty) {
        this.vshortcounty = vshortcounty;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getBaseTs() {
        return baseTs;
    }

    public void setBaseTs(String baseTs) {
        this.baseTs = baseTs;
    }

    @Override
    public String toString() {
        return "BosRegion{" +
                "pkRegion='" + pkRegion + '\'' +
                ", cparentid='" + cparentid + '\'' +
                ", bintl='" + bintl + '\'' +
                ", vprov='" + vprov + '\'' +
                ", vcity='" + vcity + '\'' +
                ", vcounty='" + vcounty + '\'' +
                ", vpostcode='" + vpostcode + '\'' +
                ", vcitycode='" + vcitycode + '\'' +
                ", coutwcorp='" + coutwcorp + '\'' +
                ", cinwcorp='" + cinwcorp + '\'' +
                ", fcitygrade=" + fcitygrade +
                ", pkProv='" + pkProv + '\'' +
                ", pkCity='" + pkCity + '\'' +
                ", ipubid=" + ipubid +
                ", vbelongcity='" + vbelongcity + '\'' +
                ", fzonerelation=" + fzonerelation +
                ", pkPriceprovpart='" + pkPriceprovpart + '\'' +
                ", vshortprov='" + vshortprov + '\'' +
                ", vshortcity='" + vshortcity + '\'' +
                ", vshortcounty='" + vshortcounty + '\'' +
                ", ts='" + ts + '\'' +
                ", dr='" + dr + '\'' +
                ", baseTs='" + baseTs + '\'' +
                '}';
    }
}
