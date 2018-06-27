package com.zjs.del.mapper;

import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:59
 * @Description:
 */
public interface ErrorCheckAddressMapper {

    /** 定时删除纠错地址表三天前的数据*/
    void delErrorCheckAddress();

    /** 查询三天之前的数据 */
    List<Integer> listIds();
}
