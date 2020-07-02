package com.jq.utils;

import com.jq.utils.JQResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class JQBaseException extends RuntimeException{

    private JQResponseCode code;

    public JQBaseException(JQResponseCode code) {
        this.code = code;
    }

    public JQBaseException(Throwable cause, JQResponseCode code) {
        super(cause);
        this.code = code;
    }
}




