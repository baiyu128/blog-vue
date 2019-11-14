package cn.baiyu.system.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther baiyu
 * @date 2019/11/14
 */
@Data
public class ArticleRqVo {
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "分类")
    private String category;
}
