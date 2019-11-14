package cn.baiyu.common.properties;

import lombok.Data;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
public class SwaggerProperties {

    private String basePackage;
    private String title;
    private String description;
    private String author;
    private String url;
    private String email;
    private String version;
}