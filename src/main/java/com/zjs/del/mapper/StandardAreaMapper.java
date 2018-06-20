package com.zjs.del.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:11
 * @Description:
 */
public interface StandardAreaMapper {

    /** 根据 地址省市区全称 删除地址 **/
    void deleteByFullname(@Param("fullname") String fullname);
}
