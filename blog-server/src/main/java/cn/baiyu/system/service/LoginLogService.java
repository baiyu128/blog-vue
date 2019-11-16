package cn.baiyu.system.service;

import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.entity.SysLoginLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
public interface LoginLogService  extends IService<SysLoginLog> {

    IPage<SysLoginLog> list(String location, String filedTime, QueryPage queryPage);

    void delete(Long id);

    void saveLog(SysLoginLog log);

    SysLoginLog lastLogin(String username);
}
