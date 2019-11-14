package cn.baiyu.system.mapper;

import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.entity.SysComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface CommentMapper extends BaseMapper<SysComment> {

    List<SysComment> findAll(@Param("state") String state, @Param("queryPage") QueryPage queryPage);
}
