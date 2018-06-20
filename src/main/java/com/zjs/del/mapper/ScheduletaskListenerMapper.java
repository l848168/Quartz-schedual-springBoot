package com.zjs.del.mapper;

import com.zjs.del.model.entity.ScheduletaskListener;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:12
 * @Description:
 */
public interface ScheduletaskListenerMapper {

    void updateByCode(@Param("code") String code, @Param("date") Date date);

    List<ScheduletaskListener> queryByDTO(Map<String, Object> paramMap);
}
