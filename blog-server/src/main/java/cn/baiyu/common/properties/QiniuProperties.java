package cn.baiyu.common.properties;

import lombok.Data;

/**
 * 七牛云配置
 *
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
public class QiniuProperties {

    /**
     * AccessKey
     */
    private String ak;

    /**
     * SecretKey
     */
    private String sk;

    /**
     * BucketName
     */
    private String bn;

    /**
     * 外链
     */
    private String url;
}