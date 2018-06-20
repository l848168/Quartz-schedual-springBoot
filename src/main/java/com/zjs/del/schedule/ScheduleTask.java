package com.zjs.del.schedule;

import com.zjs.del.common.BaseResp;
import com.zjs.del.model.entity.ScheduletaskListener;
import com.zjs.del.service.ErrorCheckAddressService;
import com.zjs.del.service.ScheduletaskListenerService;
import com.zjs.del.service.StandAreaService;
import com.zjs.del.service.TaskToLogService;
import com.zjs.del.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 16:48
 * @Description:调度
 */
@Component
public class ScheduleTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);

    private static final String NOAH_TS_MAX = "1991-01-01 01:01:01";

    private static final String SCHEDULETASK_FLG = "ENABLED";
    private static final String DELETE_STANDARDAREA_BYDR = "deleteStandardareaBydr";
    private static final String DELETE_TASK_TO_LOG="deleteTaskToLog";
    private static final String DELETE_ERRORCHECK_ADDRESS="deleteErrorCheckAddress";


    @Autowired
    private StandAreaService standAreaService;
    @Autowired
    private ScheduletaskListenerService scheduletaskListenerService;
    @Autowired
    private TaskToLogService taskToLogService;
    @Autowired
    private ErrorCheckAddressService errorCheckAddressService;


    /** bosregion表中dr为1的定时从standardarea表中删除记录*/
    public void deleteStandardareaBydr() throws Exception{
        if(isEnabled(DELETE_STANDARDAREA_BYDR)){
            LOGGER.info("---------ScheduleTask.java中deleteStandardareaBydr方法执行调度,开始time=" + DateUtil.getYMDHMS());
            long startTime = System.currentTimeMillis();
            standAreaService.deleteStandardareaBydr(DELETE_STANDARDAREA_BYDR);
            scheduletaskListenerService.updateByCode(DELETE_STANDARDAREA_BYDR, new Date());
            long endTime = System.currentTimeMillis();
            LOGGER.info("---------ScheduleTask.java中deleteStandardareaBydr方法执行调度结束,耗时={}秒", (endTime - startTime) * 1.0/1000);
        } else {
            LOGGER.info("=========deleteStandardareaBydr对应的监听器状态为关闭状态或未设置监听器信息!");
        }
    }

    /** 定时删除taskToLog表中三个月前的任务日志记录*/
    public void deleteTaskToLog() throws Exception{
        if(isEnabled(DELETE_TASK_TO_LOG)){
            LOGGER.info("---------ScheduleTask.java中deleteTaskToLog方法执行调度,开始time={}",DateUtil.getYMDHMS());
            Long startTime = System.currentTimeMillis();
            LOGGER.info("---------ScheduleTask.java中deleteTaskToLog方法执行调度,参数startCreated={}",DateUtil.getYMDHMS());
            taskToLogService.deleteTaskToLogs();
            scheduletaskListenerService.updateByCode(DELETE_TASK_TO_LOG, new Date());
            Long endTime = System.currentTimeMillis();
            LOGGER.info("---------ScheduleTask.java中deleteTaskToLog方法执行调度结束,耗时={}秒", (endTime - startTime) * 1.0/1000);
        }else {
            LOGGER.info("=========deleteTaskToLog对应的监听器状态为关闭状态或未设置监听器信息!");
        }
    }


    /** 定时删除纠错地址表三天前的数据*/
    public void deleteErrorCheckAddress() throws Exception{
        if(isEnabled(DELETE_ERRORCHECK_ADDRESS)){
            LOGGER.info("---------ScheduleTask.java中deleteErrorCheckAddress方法执行调度,开始time={}",DateUtil.getYMDHMS());
            Long startTime = System.currentTimeMillis();
            LOGGER.info("---------ScheduleTask.java中deleteErrorCheckAddress方法执行调度,参数startCreated={}",DateUtil.getYMDHMS());
            errorCheckAddressService.delErrorCheckAddress();
            scheduletaskListenerService.updateByCode(DELETE_ERRORCHECK_ADDRESS, new Date());
            Long endTime = System.currentTimeMillis();
            LOGGER.info("---------ScheduleTask.java中deleteErrorCheckAddress方法执行调度结束,耗时={}秒", (endTime - startTime) * 1.0/1000);
        }else {
            LOGGER.info("=========deleteErrorCheckAddress对应的监听器状态为关闭状态或未设置监听器信息!");
        }
    }


    private boolean isEnabled(String code) throws Exception {
        BaseResp<List<ScheduletaskListener>> baseResp = scheduletaskListenerService.queryByIdAndCode(null, code);

        List<ScheduletaskListener> stlList = baseResp.getData();
        if (stlList == null || stlList.size() == 0) {
            LOGGER.error("根据{}查询出来的记录为空!", code);
            return false;
        } else if (stlList.size() > 1) {
            LOGGER.error("根据{}查询出来的记录有多条!", code);
            return false;
        }

        ScheduletaskListener scheduletaskListener = stlList.get(0);
        if (scheduletaskListener == null) {
            return false;
        } else {
            String status = scheduletaskListener.getStatus();
            if (SCHEDULETASK_FLG.equals(status)) {
                return true;
            }
            return false;
        }
    }

}
