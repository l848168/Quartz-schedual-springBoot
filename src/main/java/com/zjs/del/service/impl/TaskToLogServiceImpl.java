package com.zjs.del.service.impl;

import com.zjs.del.mapper.TaskToLogMapper;
import com.zjs.del.service.TaskToLogService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:49
 * @Description:
 */
@Service
public class TaskToLogServiceImpl implements TaskToLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskToLogServiceImpl.class);

    @Resource
    private TaskToLogMapper taskToLogMapper;

    /** 定时删除三个月前的任务日志记录 */
    @Override
    public void deleteTaskToLogs() {
        try {
            taskToLogMapper.deleteTaskToLog();
        }catch (Exception e) {
            LOGGER.error("删除三个月前任务日志数据失败！" + ExceptionUtils.getStackTrace(e));
        }
    }
}
