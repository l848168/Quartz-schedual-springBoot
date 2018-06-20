package com.zjs.del.service;

import com.zjs.del.common.BaseResp;
import com.zjs.del.model.entity.ScheduletaskListener;

import java.util.Date;
import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 16:56
 * @Description:
 */
public interface ScheduletaskListenerService {

    BaseResp<List<ScheduletaskListener>> queryByIdAndCode(Long id, String code) throws Exception;

    void updateByCode(String code, Date date) throws Exception;
}
