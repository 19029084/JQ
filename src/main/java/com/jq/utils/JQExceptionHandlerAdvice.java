package com.jq.utils;

import com.jq.utils.JQBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.HttpClientErrorException;


/**
 * 异常处理器
 *
 * @author NULL
 * @since  2019-07-16
 */
@ControllerAdvice(annotations = JQBaseResponse.class)
@ResponseBody
@Slf4j
public class JQExceptionHandlerAdvice {
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public JQResponse handleException(Exception e){
        log.error(e.getMessage(),e);
        System.out.println("Exception");
        if((e instanceof UsernameNotFoundException) || (e instanceof BadCredentialsException)||(e instanceof HttpClientErrorException))
        	 return new JQResponse(401,"认证失败",null);
        else
        {
         
        	return new JQResponse(JQResponseCode.SERVICE_ERROR.getCode(),JQResponseCode.SERVICE_ERROR.getMsg(),null);
        }
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public JQResponse handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        
        System.out.println("RuntimeException");
       
         if((e instanceof UsernameNotFoundException) || (e instanceof BadCredentialsException) || (e instanceof HttpClientErrorException))
        	 return new JQResponse(401,"认证失败",null);
        else
        {
         
        	return new JQResponse(JQResponseCode.SERVICE_ERROR.getCode(),JQResponseCode.SERVICE_ERROR.getMsg(),null);
        }    }

    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(JQBaseException.class)
    public JQResponse handleBaseException(JQBaseException e){
    
        log.error(e.getMessage(),e);
        
        System.out.println("handleBaseException");
        JQResponseCode code=e.getCode();
        return new JQResponse(code.getCode(),code.getMsg(),null);
    }
}



