package com.mantao.springrest.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Manito on 2019/3/8.
 */
@Getter
@Setter
public class ErrorInfo {
    String code;
    String message;
    String detailMessage;
}
