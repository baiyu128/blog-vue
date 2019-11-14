package cn.baiyu.system.service;

import cn.baiyu.system.entity.ArticleCategory;
import cn.baiyu.system.mapper.ArticleCategoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 新增
     *
     * @param articleCategory
     */
    void add(ArticleCategory articleCategory);

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    void deleteByArticleId(Long id);

    /**
     * 根据分类ID删除
     *
     * @param id
     */
    void deleteByCategoryId(Long id);
}
