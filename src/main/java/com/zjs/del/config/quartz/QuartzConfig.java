package com.zjs.del.config.quartz;

import com.zjs.del.schedule.ScheduleTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import javax.annotation.Resource;

/**
 * @Author: Liwh
 * @Date: 2018/6/15 13:34
 * @Description:
 */
@Configuration
public class QuartzConfig {


    @Resource
    private ScheduleTask scheduleTask;

    /**
     * 配置定时任务1
     * @return
     */
    @Bean(name="firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(){
        MethodInvokingJobDetailFactoryBean method = new MethodInvokingJobDetailFactoryBean();
        // 为需要执行的实体类对应的对象
        method.setTargetObject(scheduleTask);
        // 需要执行的方法
        method.setTargetMethod("deleteTaskToLog");
        // 是否并发执行
        method.setConcurrent(false);
        return method;
    }

    /**
     *  配置定时任务2
     * @return
     */
    @Bean(name="secondJobDetail")
    public MethodInvokingJobDetailFactoryBean secondJobDetail(){
        MethodInvokingJobDetailFactoryBean method = new MethodInvokingJobDetailFactoryBean();
        // 为需要执行的实体类对应的对象
        method.setTargetObject(scheduleTask);
        // 需要执行的方法
        method.setTargetMethod("deleteErrorCheckAddress");
        // 是否并发执行
        method.setConcurrent(false);
        return method;
    }

    /**
     *  配置定时任务3
     * @return
     */
    @Bean(name="thirdJobDetail")
    public MethodInvokingJobDetailFactoryBean thirdJobDetail(){
        MethodInvokingJobDetailFactoryBean method = new MethodInvokingJobDetailFactoryBean();
        // 为需要执行的实体类对应的对象
        method.setTargetObject(scheduleTask);
        // 需要执行的方法
        method.setTargetMethod("deleteStandardareaBydr");
        // 是否并发执行
        method.setConcurrent(false);
        return method;
    }

    /**
     * 配置同步历史地址库数据定时任务
     */
    @Bean(name = "fourJobDetail")
    public MethodInvokingJobDetailFactoryBean fourJobDetail(){
        MethodInvokingJobDetailFactoryBean method = new MethodInvokingJobDetailFactoryBean();
        // 为需要执行的实体类对应的对象
        method.setTargetObject(scheduleTask);
        // 需要执行的方法
        method.setTargetMethod("syncHistAddr");
        // 是否并发执行
        method.setConcurrent(false);
        return method;
    }

    /**
     *   配置触发器1
     *   @param firstJobDetail
     *   @return
     */
    @Bean(name="firstTrigger")
    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail){
        SimpleTriggerFactoryBean simpleBean = new SimpleTriggerFactoryBean();
        simpleBean.setJobDetail(firstJobDetail);
        // 设置任务启动延迟
        simpleBean.setStartDelay(1000);
        // 每1秒执行一次
        simpleBean.setRepeatInterval(1000);
        //设置重复计数
        //simpleBean.setRepeatCount(0);
        return simpleBean;
    }

    /**
     *   配置触发器2
     *   @param secondJobDetail
     *   @return
     */
    @Bean(name="secondTrigger")
    public SimpleTriggerFactoryBean secondTrigger(JobDetail secondJobDetail){
        SimpleTriggerFactoryBean simpleBean = new SimpleTriggerFactoryBean();
        simpleBean.setJobDetail(secondJobDetail);
        // 设置任务启动延迟
        simpleBean.setStartDelay(1000);
        // 每1秒执行一次
        simpleBean.setRepeatInterval(1001);
        //设置重复计数
        //simpleBean.setRepeatCount(0);
        return simpleBean;
    }


    /**
     *  配置触发器3,配置触发器cron形式
     * @param thirdJobDetail
     * @return
     */
    @Bean(name = "thirdTrigger")
    public CronTriggerFactoryBean thirdTrigger(JobDetail thirdJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(thirdJobDetail);
        // cron表达式
        trigger.setCronExpression("0 0 4 4 * ?");
        return trigger;
    }

    /**
     * 配置触发器4
     * @return
     */
    @Bean(name="fourTrigger")
    public SimpleTriggerFactoryBean fourTrigger(JobDetail fourJobDetail){
        SimpleTriggerFactoryBean simpleBean = new SimpleTriggerFactoryBean();
        simpleBean.setJobDetail(fourJobDetail);
        // 设置任务启动延迟
        simpleBean.setStartDelay(1000);
        // 每1秒执行一次
        simpleBean.setRepeatInterval(1001);
        //设置重复计数
        //simpleBean.setRepeatCount(0);
        return simpleBean;
    }
    /**
     *  配置Scheduler
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger firstTrigger,Trigger secondTrigger,
                                                     Trigger thirdTrigger,Trigger fourTrigger){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(firstTrigger,secondTrigger,thirdTrigger,fourTrigger);
        return factoryBean;
    }



}
