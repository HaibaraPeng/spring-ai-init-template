package com.example.controller.log;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.base.Constants;
import com.example.common.base.R;
import com.example.model.common.PageModel;
import com.example.model.dto.log.LogPageDto;
import com.example.model.vo.log.LogExportVo;
import com.example.model.vo.log.LogPageVo;
import com.example.service.LogService;
import com.example.utils.document.excel.ExcelUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Peng
 * @date 2025-10-16 19:24
 */
@RestController
@RequestMapping("/log")
@SaCheckLogin
public class LogController {

    @Resource
    private LogService logService;

    /**
     * 管理员分页查询日志信息
     *
     * @param logPageDto 日志信息查询条件
     * @param pageModel  分页模型
     * @return 分页查询结果
     */
    @GetMapping("/page")
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Page<LogPageVo>> pageLog(LogPageDto logPageDto, PageModel pageModel) {
        Page<LogPageVo> page = logService.pageLog(logPageDto, pageModel);
        return R.ok(page);
    }

    /**
     * 管理员删除日志信息
     *
     * @param id 日志ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> deleteLog(@PathVariable("id") Long id) {
        logService.deleteLog(id);
        return R.ok("删除成功");
    }

    /**
     * 管理员清空日志信息
     *
     * @return 清空结果
     */
    @DeleteMapping("/clear")
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> clearLog() {
        logService.clearLog();
        return R.ok("清空日志成功");
    }

    /**
     * 导出日志表格
     *
     * @return 导出表格
     */
    @GetMapping("/export")
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Void> exportLog(HttpServletResponse response) {
        List<LogExportVo> list = logService.exportExcelList();
        ExcelUtils.exportHttpServletResponse(list, "日志表", LogExportVo.class, response);
        return R.empty();
    }

}
