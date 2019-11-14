package cn.baiyu.system.controller;

import cn.baiyu.common.annotation.Log;
import cn.baiyu.common.controller.BaseController;
import cn.baiyu.common.exception.GlobalException;
import cn.baiyu.common.utils.QueryPage;
import cn.baiyu.common.utils.R;
import cn.baiyu.system.entity.SysLink;
import cn.baiyu.system.service.LinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther baiyu
 * @date 2019/11/2
 */
@RestController
@RequestMapping("/api/link")
@Api(value = "LinkController", tags = {"友链管理接口"})
public class LinkController extends BaseController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/findAll")
    public R findAll() {
        return new R<>(linkService.list(new QueryWrapper<>()));
    }

    @GetMapping("/list")
    public R list(String name, QueryPage queryPage) {
        return new R<>(super.getData(linkService.list(name, queryPage)));
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(linkService.getById(id));
    }

    @PostMapping
    @Log("新增友链")
    public R save(@RequestBody SysLink link) {
        try {
            linkService.add(link);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新友链")
    public R update(@RequestBody SysLink link) {
        try {
            linkService.update(link);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除友链")
    public R delete(@PathVariable Long id) {
        try {
            linkService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
