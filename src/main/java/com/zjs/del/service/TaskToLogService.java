package com.zjs.del.service;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:48
 * @Description:
 */
public interface TaskToLogService {

    /** 定时删除三个月前的任务日志记录 */
    void deleteTaskToLogs();
}
