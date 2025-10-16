package com.example.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.common.PageModel;
import com.example.model.dto.log.LogPageDto;
import com.example.model.entity.Log;
import com.example.model.vo.log.LogExportVo;
import com.example.model.vo.log.LogPageVo;

import java.util.List;

/**
 * @author Peng
 * @date 2025-10-16 19:25
 */
public interface LogService extends IService<Log> {

    /**
     * 管理员分页查询日志信息
     *
     * @param logPageDto 日志信息查询条件
     * @param pageModel  分页模型
     * @return 分页查询结果
     */
    Page<LogPageVo> pageLog(LogPageDto logPageDto, PageModel pageModel);

    /**
     * 管理员删除日志信息
     *
     * @param id 日志ID
     */
    void deleteLog(Long id);

    /**
     * 管理员清空日志信息
     */
    void clearLog();

    /**
     * 导出日志表格
     *
     * @return 导出表格
     */
    List<LogExportVo> exportExcelList();
}
