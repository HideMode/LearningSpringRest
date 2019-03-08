package com.mantao.springrest.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Manito on 2019/3/8.
 */
@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {

    /**
     * RunTimeException
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = { RuntimeException.class })
    public ErrorInfo handleRuntimeException(RuntimeException e, WebRequest request) {
        log.error("MethodArgumentNotValidException", e);
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode("500");
        errorInfo.setMessage("系统异常");
        errorInfo.setDetailMessage(e.getMessage());
        return errorInfo;
    }

}
