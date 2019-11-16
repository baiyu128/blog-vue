package cn.baiyu.system.service;

import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.entity.SysVisitLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther baiyu
 * @date 2019/11/16
 */
public interface VisitLogService extends IService<SysVisitLog> {

    IPage<SysVisitLog> list(String time, QueryPage queryPage);

    void saveLog();

    Integer count(String time);
}
