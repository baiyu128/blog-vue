package cn.baiyu.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
@SpringBootConfiguration
@PropertySource(value = "classpath:blog.properties", encoding = "utf-8")
@ConfigurationProperties(prefix = "blog")
public class BlogProperties {

    private QiniuProperties qiniu = new QiniuProperties();

    private ShiroProperties shiro = new ShiroProperties();

    private SwaggerProperties swagger = new SwaggerProperties();
}
