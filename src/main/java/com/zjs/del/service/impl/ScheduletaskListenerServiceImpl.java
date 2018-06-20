package com.zjs.del.service.impl;

import com.zjs.del.common.BaseResp;
import com.zjs.del.exception.BusinessException;
import com.zjs.del.mapper.ScheduletaskListenerMapper;
import com.zjs.del.model.entity.ScheduletaskListener;
import com.zjs.del.service.ScheduletaskListenerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:34
 * @Description:
 */
@Service
public class ScheduletaskListenerServiceImpl implements ScheduletaskListenerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandAreaServiceImpl.class);

    @Resource
    private ScheduletaskListenerMapper scheduletaskListenerMapper;

    @Override
    public void updateByCode(String code, Date date) throws Exception {
        if (StringUtils.isEmpty(code)) {
            throw new BusinessException("code不能为空!");
        }
        if (date == null) {
            date = new Date();
        }
        scheduletaskListenerMapper.updateByCode(code, date);
    }

    @Override
    public BaseResp<List<ScheduletaskListener>> queryByIdAndCode(Long id, String code) throws Exception {
        BaseResp<List<ScheduletaskListener>> baseResp = new BaseResp<List<ScheduletaskListener>>();

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("code", code);
        List<ScheduletaskListener> stlList = scheduletaskListenerMapper.queryByDTO(paramMap);
        baseResp.setData(stlList);
        if (stlList == null || stlList.size() == 0) {
            baseResp.setDescription("数据有误!");
            baseResp.setCode(BaseResp.FAIlURE);
        } else {
            baseResp.setDescription("查询成功!");
            baseResp.setCode(BaseResp.SUCCESS);
        }
        return baseResp;
    }
}
