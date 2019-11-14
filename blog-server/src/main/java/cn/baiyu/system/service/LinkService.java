package cn.baiyu.system.service;

import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.entity.SysLink;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface LinkService  extends IService<SysLink> {

    IPage<SysLink> list(SysLink link, QueryPage queryPage);

    void add(SysLink link);

    void update(SysLink link);

    void delete(Long id);
}
