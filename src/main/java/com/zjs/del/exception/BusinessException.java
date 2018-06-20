package com.zjs.del.exception;

/**
 * @Author: Liwh
 * @Date: 2018/6/13 17:40
 * @Description:
 */
public class BusinessException extends  RuntimeException {
    public BusinessException(String s) {
        super(s);
    }
}
