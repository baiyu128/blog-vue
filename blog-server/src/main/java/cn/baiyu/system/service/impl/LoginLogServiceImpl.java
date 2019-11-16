package cn.baiyu.system.service.impl;

import cn.baiyu.common.utils.DateUtil;
import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.system.entity.SysLoginLog;
import cn.baiyu.system.mapper.LoginLogMapper;
import cn.baiyu.system.service.LoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, SysLoginLog> implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public IPage<SysLoginLog> list(String location, String filedTime, QueryPage queryPage) {
        IPage<SysLoginLog> page = new Page<>(queryPage.getPage(), queryPage.getLimit());
        LambdaQueryWrapper<SysLoginLog> queryWrapper = new QueryWrapper<SysLoginLog>().lambda();
        queryWrapper.like(StringUtils.isNotBlank(location), SysLoginLog::getLocation, location);
        queryWrapper.orderByDesc(SysLoginLog::getCreateTime);
        if (StringUtils.isNotBlank(filedTime)) {
            String[] split = filedTime.split(",");
            queryWrapper.gt(SysLoginLog::getCreateTime, split[0]);
            queryWrapper.lt(SysLoginLog::getCreateTime, split[1]);
        }
        return loginLogMapper.selectPage(page, queryWrapper);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        loginLogMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void saveLog(SysLoginLog log) {
        loginLogMapper.insert(log);
    }

    @Override
    public SysLoginLog lastLogin(String username) {
        LambdaQueryWrapper<SysLoginLog> queryWrapper = new QueryWrapper<SysLoginLog>().lambda();
        queryWrapper.eq(StringUtils.isNotBlank(username), SysLoginLog::getUsername, username);
        queryWrapper.gt(SysLoginLog::getCreateTime, DateUtil.getSpecifiedDayBeforeOrAfter(1));
        queryWrapper.orderByDesc(SysLoginLog::getCreateTime);
        List<SysLoginLog> sysLoginLogs = loginLogMapper.selectList(queryWrapper);
        if (!sysLoginLogs.isEmpty()) return sysLoginLogs.get(0);
        return null;
    }
}
