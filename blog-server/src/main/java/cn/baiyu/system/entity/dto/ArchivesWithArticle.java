package cn.baiyu.system.entity.dto;

import cn.baiyu.system.entity.SysArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装Article表按时间归档的DTO
 *
 * @auther baiyu
 * @date 2019/11/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivesWithArticle implements Serializable {

    private String date;
    private List<SysArticle> articles;
}
