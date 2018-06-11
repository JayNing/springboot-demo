package com.ning.springbootdemo.controller;

import com.ning.springbootdemo.dto.ReturnMsg;
import com.ning.springbootdemo.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BaseController {

    /***
     *  配置ControllerAdvice和ExceptionHandler注解，可以进行统一自定义异常处理
     * **/

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    @ResponseBody
    public ReturnMsg exp(HttpServletRequest request, HttpServletResponse response, Exception e){

        ReturnMsg msg = new ReturnMsg();

        if (e instanceof BizException){
            logger.info("exception : " + e);
            msg.addErrorMsg(((BizException) e).getMsg());
            msg.setErrorCode(((BizException) e).getCode());
        }else {
            msg.setErrorCode(-90);
            msg.addErrorMsg(e.getMessage());
        }

        return msg;
    }

}