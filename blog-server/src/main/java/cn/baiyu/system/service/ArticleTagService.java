package cn.baiyu.system.service;

import cn.baiyu.system.entity.ArticleTag;
import cn.baiyu.system.entity.SysArticle;
import cn.baiyu.system.entity.SysTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface ArticleTagService extends IService<ArticleTag> {

    /**
     * 新增关联关系
     *
     * @param articleTag
     */
    void add(ArticleTag articleTag);

    /**
     * 根据文章ID查询文章+标签数据
     *
     * @param articleId
     * @return
     */
    List<SysTag> findByArticleId(Long articleId);

    /**
     * 根据标签ID查询文章+标签数据
     *
     * @param tagId
     * @return
     */
    List<ArticleTag> findByTagId(Long tagId);

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    void deleteByArticleId(Long id);

    /**
     * 根据标签ID删除
     *
     * @param id
     */
    void deleteByTagsId(Long id);

    /**
     * 根据标签名称查询关联的文章
     *
     * @param tag
     * @return
     */
    List<SysArticle> findByTagName(String tag);
}
