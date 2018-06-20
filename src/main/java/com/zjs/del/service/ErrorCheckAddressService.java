package com.zjs.del.service;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:57
 * @Description:
 */
public interface ErrorCheckAddressService {

    /** 定时删除纠错地址表三天前的数据*/
    void delErrorCheckAddress();
}
