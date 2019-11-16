package cn.baiyu.system.controller;

import cn.baiyu.common.annotation.Log;
import cn.baiyu.common.controller.BaseController;
import cn.baiyu.common.exception.GlobalException;
import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.common.utils.R;
import cn.baiyu.system.entity.SysLoginLog;
import cn.baiyu.system.entity.SysUser;
import cn.baiyu.system.service.LoginLogService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@RestController
@RequestMapping("/api/loginlog")
@Api(value = "LoginLogController", tags = {"登录日志管理接口"})
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    @GetMapping("/list")
    public R findByPage(String location, String filedTime, QueryPage queryPage) {
        return new R<>(super.getData(loginLogService.list(location, filedTime, queryPage)));
    }

    @Log("删除登录日志")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            loginLogService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/last")
    public R last(){
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysLoginLog loginLog = loginLogService.lastLogin(sysUser.getUsername());
        return new R<>(loginLog);
    }
}