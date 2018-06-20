package com.zjs.del.service.impl;

import com.zjs.del.mapper.BosRegionMapper;
import com.zjs.del.mapper.StandardAreaMapper;
import com.zjs.del.model.dto.BosRegionDTO;
import com.zjs.del.service.StandAreaService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 16:56
 * @Description:
 */
@Service
public class StandAreaServiceImpl implements StandAreaService {


    private static final Logger LOGGER = LoggerFactory.getLogger(StandAreaServiceImpl.class);


    @Resource
    private StandardAreaMapper standardAreaMapper;
    @Resource
    private BosRegionMapper bosRegionMapper;

    /**
     * bosregion表中dr为1的定时从standardarea表中删除记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long deleteStandardareaBydr(String code) {
        List<BosRegionDTO> bosRegionDTOS = bosRegionMapper.queryAllByDr();
        if (bosRegionDTOS.size() > 0) {
            for (BosRegionDTO bosRegionDTO : bosRegionDTOS) {
                String fullName = "";
                if (!StringUtils.isEmpty(bosRegionDTO.getVprov())) {
                    fullName += bosRegionDTO.getVprov() + "-";
                }
                if (!StringUtils.isEmpty(bosRegionDTO.getVcity())) {
                    fullName += bosRegionDTO.getVcity() + "-";
                }
                if (!StringUtils.isEmpty(bosRegionDTO.getVcounty())) {
                    fullName += bosRegionDTO.getVcounty();
                }
                standardAreaMapper.deleteByFullname(fullName);
            }
        }
        return 0;
    }

}
