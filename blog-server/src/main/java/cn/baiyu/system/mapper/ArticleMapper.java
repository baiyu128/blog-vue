package cn.baiyu.system.mapper;

import cn.baiyu.system.entity.SysArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface ArticleMapper extends BaseMapper<SysArticle> {

    List<String> findArchivesDates();

    List<SysArticle> findArchivesByDate(String date);
}
