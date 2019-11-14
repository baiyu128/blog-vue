package cn.baiyu.system.mapper;

import cn.baiyu.system.entity.ArticleTag;
import cn.baiyu.system.entity.SysArticle;
import cn.baiyu.system.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    List<SysTag> findByArticleId(long articleId);

    List<SysArticle> findByTagName(String name);
}
