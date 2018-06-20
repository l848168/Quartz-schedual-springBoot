package com.zjs.del.service;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 16:55
 * @Description:
 */
public interface StandAreaService {

    /**
     * bosregion表中dr为1的定时从standardarea表中删除记录
     * */
    long deleteStandardareaBydr(String code);
}
