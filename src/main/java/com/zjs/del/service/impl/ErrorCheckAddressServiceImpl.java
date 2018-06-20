package com.zjs.del.service.impl;

import com.zjs.del.mapper.ErrorCheckAddressMapper;
import com.zjs.del.service.ErrorCheckAddressService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:58
 * @Description:
 */
@Service
public class ErrorCheckAddressServiceImpl implements ErrorCheckAddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCheckAddressServiceImpl.class);
    @Autowired
    private ErrorCheckAddressMapper errorCheckAddressMapper;

    /** 定时删除纠错地址表三天前的数据*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delErrorCheckAddress() {
        try {
            errorCheckAddressMapper.delErrorCheckAddress();
        }catch (Exception e){
            LOGGER.error("---------删除纠错地址失败！" + ExceptionUtils.getStackTrace(e));
        }
    }
}
