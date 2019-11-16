package cn.baiyu.system.service.impl;

import cn.baiyu.common.constans.CommonConstant;
import cn.baiyu.common.utils.*;
import cn.baiyu.system.entity.SysVisitLog;
import cn.baiyu.system.mapper.VisitLogMapper;
import cn.baiyu.system.service.VisitLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @auther baiyu
 * @date 2019/11/16
 */
@Service
public class VisitLogServiceImpl extends ServiceImpl<VisitLogMapper, SysVisitLog> implements VisitLogService {

    @Autowired
    private VisitLogMapper visitLogMapper;

    public IPage<SysVisitLog> list(String time, QueryPage queryPage) {
        IPage<SysVisitLog> page = new Page<>(queryPage.getPage(), queryPage.getLimit());
        LambdaQueryWrapper<SysVisitLog> queryWrapper = new QueryWrapper<SysVisitLog>().lambda();
        queryWrapper.gt(StringUtils.isNotBlank(time),SysVisitLog::getCreateTime, DateUtil.convertStringToDate(time));
        queryWrapper.orderByDesc(SysVisitLog::getCreateTime);
        return visitLogMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void saveLog() {

        //记录登录日志
        SysVisitLog log = new SysVisitLog();
        //获取HTTP请求
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        log.setIp(ip);
        log.setLocation(AddressUtil.getAddress(ip));
        log.setCreateTime(new Date());
        String header = request.getHeader(CommonConstant.USER_AGENT);
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        log.setDevice(browser.getName() + " -- " + operatingSystem.getName());

        LambdaQueryWrapper<SysVisitLog> queryWrapper = new QueryWrapper<SysVisitLog>().lambda();
        queryWrapper.eq(SysVisitLog::getIp, log.getIp());
        SysVisitLog visitLog = visitLogMapper.selectOne(queryWrapper);
        if (visitLog != null){
            visitLog.setCreateTime(log.getCreateTime());
            visitLogMapper.updateById(visitLog);
        }else {
            visitLogMapper.insert(log);
        }
    }

    @Override
    public Integer count(String time) {
        LambdaQueryWrapper<SysVisitLog> queryWrapper = new QueryWrapper<SysVisitLog>().lambda();
        queryWrapper.gt(StringUtils.isNotBlank(time),SysVisitLog::getCreateTime, DateUtil.convertStringToDate(time));
        queryWrapper.orderByDesc(SysVisitLog::getCreateTime);
        return visitLogMapper.selectCount(queryWrapper);
    }
}
