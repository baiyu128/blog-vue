package cn.baiyu.system.service;

import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.controller.vo.ArticleRqVo;
import cn.baiyu.system.entity.SysArticle;
import cn.baiyu.system.entity.dto.ArchivesWithArticle;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface ArticleService extends IService<SysArticle> {

    /**
     * 查询最新的8条记录
     *
     * @return
     */
    List<SysArticle> findAll();

    /**
     * 分页查询
     *
     * @param queryPage
     * @return
     */
    IPage<SysArticle> list(ArticleRqVo articleRqVo, QueryPage queryPage);

    /**
     * 根据ID 查询
     *
     * @param id
     * @return
     */
    SysArticle findById(Long id);

    /**
     * 更新
     *
     * @param sysArticle
     */
    void update(SysArticle sysArticle);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 分页查询，为博客前台服务
     *
     * @param queryPage
     * @return
     */
    IPage<SysArticle> findByPageForSite(QueryPage queryPage);

    /**
     * 根据分类名称查询文章数据
     *
     * @param category
     * @return
     */
    List<SysArticle> findByCategory(String category);

    /**
     * 查询按照时间归档的整合数据，
     * 格式：[{"2018-01", [{article},{article}...]}, {"2018-02", [{article}, {article}...]}]
     *
     * @return
     */
    List<ArchivesWithArticle> findArchives();

    /**
     * 添加
     *
     * @param sysArticle
     */
    void add(SysArticle sysArticle);
}
