package cn.baiyu.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public class GlobalException extends RuntimeException {

    @Getter
    @Setter
    private String msg;

    public GlobalException(String message) {
        super(message);
        this.msg = message;
    }
}
