package com.zjs.del.mapper;

import com.zjs.del.model.dto.BosRegionDTO;

import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:13
 * @Description:
 */
public interface BosRegionMapper {

    /**查询dr为1的数据 */
    List<BosRegionDTO> queryAllByDr();
}
