package cn.baiyu.system.mapper;

import cn.baiyu.system.entity.SysCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface CategoryMapper extends BaseMapper<SysCategory> {

    List<SysCategory> findCategoryByArticleId(long id);
}
