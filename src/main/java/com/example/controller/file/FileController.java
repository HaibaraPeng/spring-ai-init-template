package com.example.controller.file;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.base.Constants;
import com.example.common.base.R;
import com.example.common.base.ReturnCode;
import com.example.common.validate.PostGroup;
import com.example.config.log.annotation.ControllerLog;
import com.example.config.log.enums.Operator;
import com.example.exception.customize.CustomizeReturnException;
import com.example.model.common.PageModel;
import com.example.model.dto.file.FileAddDto;
import com.example.model.dto.file.FilePageDto;
import com.example.model.vo.file.FileExportVo;
import com.example.model.vo.file.FilePageVo;
import com.example.service.FileService;
import com.example.utils.document.excel.ExcelUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Peng
 * @date 2025-10-10 16:51
 */
@RestController
@RequestMapping("/file")
@SaCheckLogin
public class FileController {

    /**
     * 文件最大大小
     */
    private static final int FILE_MAX_SIZE = 10 * 1024 * 1024;

    @Resource
    private FileService fileService;

    /**
     * 管理员分页查询文件信息
     *
     * @param filePageDto 文件信息查询条件
     * @param pageModel   分页模型
     * @return 分页查询结果
     */
    @GetMapping("/page")
    @ControllerLog(description = "管理员查询文件信息", operator = Operator.QUERY)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Page<FilePageVo>> pageFile(FilePageDto filePageDto, PageModel pageModel) {
        // 处理一下文件后缀名查询条件，如果存在则转为小写
        if (StringUtils.isNotBlank(filePageDto.getOssType())) {
            filePageDto.setOssType(filePageDto.getOssType().toLowerCase());
        }
        Page<FilePageVo> file = fileService.pageFile(filePageDto, pageModel);
        return R.ok(file);
    }

    /**
     * 管理员添加文件信息
     *
     * @param fileAddDto 被添加文件信息
     * @return 添加结果
     */
    @PostMapping("/add")
    @ControllerLog(description = "管理员添加文件信息", operator = Operator.INSERT)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> addFile(@Validated({PostGroup.class}) FileAddDto fileAddDto) {
        MultipartFile file = fileAddDto.getFile();
        if (file.getSize() == 0 || file.getSize() > FILE_MAX_SIZE) {
            throw new CustomizeReturnException(ReturnCode.USER_UPLOADED_FILE_IS_TOO_LARGE, "文件不得大于10MB");
        }
        fileService.addFile(file);
        return R.ok("添加成功");
    }

    /**
     * 管理员删除文件信息
     *
     * @param id 文件ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    @ControllerLog(description = "管理员删除文件信息", operator = Operator.DELETE)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> deleteFile(@PathVariable("id") Long id) {
        fileService.deleteFile(id);
        return R.ok("删除成功");
    }

    /**
     * 导出文件表格
     *
     * @return 导出表格
     */
    @GetMapping("/export")
    @ControllerLog(description = "管理员导出文件表格", operator = Operator.QUERY)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Void> exportFile(HttpServletResponse response) {
        List<FileExportVo> list = fileService.exportExcelList();
        ExcelUtils.exportHttpServletResponse(list, "文件表", FileExportVo.class, response);
        return R.empty();
    }

}
