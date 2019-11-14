package cn.baiyu.common.properties;

import lombok.Data;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    private int cookieTimeout;
    private String anonUrl;
}