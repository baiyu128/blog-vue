package cn.baiyu.system.controller;

import cn.baiyu.common.constans.CommonConstant;
import cn.baiyu.common.controller.BaseController;
import cn.baiyu.common.utils.AddressUtil;
import cn.baiyu.common.utils.HttpContextUtil;
import cn.baiyu.common.utils.IPUtil;
import cn.baiyu.common.utils.R;
import cn.baiyu.system.entity.SysLoginLog;
import cn.baiyu.system.service.LoginLogService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@RestController
@Api(value = "LoginController", tags = {"登录接口"})
public class LoginController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestParam(value = "username", required = false) String username,
                   @RequestParam(value = "password", required = false) String password) {
        Subject subject = getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);

            //记录登录日志
            SysLoginLog log = new SysLoginLog();
            //获取HTTP请求
            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
            String ip = IPUtil.getIpAddr(request);
            log.setIp(ip);
            log.setUsername(super.getCurrentUser().getUsername());
            log.setLocation(AddressUtil.getAddress(ip));
            log.setCreateTime(new Date());
            String header = request.getHeader(CommonConstant.USER_AGENT);
            UserAgent userAgent = UserAgent.parseUserAgentString(header);
            Browser browser = userAgent.getBrowser();
            OperatingSystem operatingSystem = userAgent.getOperatingSystem();
            log.setDevice(browser.getName() + " -- " + operatingSystem.getName());
            loginLogService.saveLog(log);

            return new R<>(this.getToken());
        } catch (Exception e) {
            e.printStackTrace();
            return new R<>(e);
        }
    }

    /**
     * 注销接口
     *
     * @return
     */
    @GetMapping(value = "/logout")
    public R logout() {
        Subject subject = getSubject();
        subject.logout();
        return new R();
    }
}
