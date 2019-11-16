package cn.baiyu.system.controller;

import cn.baiyu.common.controller.BaseController;
import cn.baiyu.common.exception.GlobalException;
import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.common.utils.R;
import cn.baiyu.system.entity.SysLog;
import cn.baiyu.system.service.LogService;
import cn.baiyu.system.service.VisitLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@RestController
@RequestMapping("/api/log")
@Api(value = "LogController", tags = {"日志管理接口"})
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @Autowired
    private VisitLogService visitLogService;

    @GetMapping("/list")
    public R findByPage(String username, String ip, QueryPage queryPage) {
        return new R<>(super.getData(logService.list(username, ip, queryPage)));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            logService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/visit")
    public R visitPage(String time,QueryPage queryPage){
        return new R<>(super.getData(visitLogService.list(time, queryPage)));
    }

    @GetMapping("/visitCount")
    public R vitSum(String time){
        return new R<>(visitLogService.count(time));
    }
}
