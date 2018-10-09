package com.zjs.del.model.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Liwh on 2018/4/19.
 * Description:历史地址属性实体类
 */
@Data
@Document(collection = "FD_HIST_ADDR")
public class HistAddrWritePro implements Serializable{

    private static final long serialVersionUID = -5602615846503471496L;

    private String id; //地址经md5加密字符串

    private String orderId;//订单号

    private String address; //地址

    private String lng;    //经度

    private String lat;    //纬度

    private String provice;     //省份

    private String city;    //市

    private String countyName;  //区

    private Date createTime;    //创建时间

    private Integer frequency;  //次数(出现次数)

    private Date lastModifyTime;    //修改时间

    private String modifierId;  //修改人工号

    private String modifier;    //修改人姓名

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistAddrWritePro that = (HistAddrWritePro) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(address, that.address) &&
                Objects.equals(lng, that.lng) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(provice, that.provice) &&
                Objects.equals(city, that.city) &&
                Objects.equals(countyName, that.countyName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(frequency, that.frequency) &&
                Objects.equals(lastModifyTime, that.lastModifyTime) &&
                Objects.equals(modifierId, that.modifierId) &&
                Objects.equals(modifier, that.modifier);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address, lng, lat, provice, city, countyName, createTime, frequency, lastModifyTime, modifierId, modifier);
    }
}
