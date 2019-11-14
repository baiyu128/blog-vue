package cn.baiyu.system.mapper;

import cn.baiyu.system.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface TagMapper extends BaseMapper<SysTag> {

    List<SysTag> findByArticleId(long id);
}
