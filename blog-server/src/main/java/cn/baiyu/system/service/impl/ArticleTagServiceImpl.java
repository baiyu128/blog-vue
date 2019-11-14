
package cn.baiyu.system.service.impl;

import cn.baiyu.system.entity.ArticleTag;
import cn.baiyu.system.entity.SysArticle;
import cn.baiyu.system.entity.SysTag;
import cn.baiyu.system.mapper.ArticleTagMapper;
import cn.baiyu.system.service.ArticleTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    @Transactional
    public void add(ArticleTag articleTag) {
        if (!exists(articleTag)) {
            articleTagMapper.insert(articleTag);
        }
    }

    private boolean exists(ArticleTag articleTag) {
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getArticleId, articleTag.getArticleId());
        queryWrapper.eq(ArticleTag::getTagId, articleTag.getTagId());
        return articleTagMapper.selectList(queryWrapper).size() > 0 ? true : false;
    }


    @Override
    public List<SysTag> findByArticleId(Long articleId) {
        return articleTagMapper.findByArticleId(articleId);
    }

    @Override
    public List<ArticleTag> findByTagId(Long tagId) {
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getTagId, tagId);
        return articleTagMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void deleteByArticleId(Long id) {
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getArticleId, id);
        articleTagMapper.delete(queryWrapper);
    }

    @Override
    @Transactional
    public void deleteByTagsId(Long id) {
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getTagId, id);
        articleTagMapper.delete(queryWrapper);
    }

    @Override
    public List<SysArticle> findByTagName(String tag) {
        return articleTagMapper.findByTagName(tag);
    }
}
