package com.zjs.del.mapper;

import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:50
 * @Description:任务日志Mapper
 */
public interface TaskToLogMapper {
    /**
     * 删除任务日志
     */
    void deleteTaskToLog();

    /**
     * 查询三个月之前的任务日志
     */
    List<Integer> listIds();

}
