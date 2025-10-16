package com.example.controller.model;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.base.Constants;
import com.example.common.base.R;
import com.example.common.base.ReturnCode;
import com.example.common.validate.GetGroup;
import com.example.common.validate.PostGroup;
import com.example.common.validate.PutGroup;
import com.example.config.log.annotation.ControllerLog;
import com.example.config.log.enums.Operator;
import com.example.exception.customize.CustomizeReturnException;
import com.example.model.common.PageModel;
import com.example.model.dto.model.ModelAddOrUpdateDto;
import com.example.model.dto.model.ModelPageDto;
import com.example.model.dto.model.ModelUpdateStateDto;
import com.example.model.enums.ModelTypeService;
import com.example.model.vo.model.ModelExportVo;
import com.example.model.vo.model.ModelPageVo;
import com.example.service.ModelService;
import com.example.utils.document.excel.ExcelUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Peng
 * @date 2025-10-16 19:29
 */
@RestController
@RequestMapping("/model")
@SaCheckLogin
public class ModelController {

    @Resource
    private ModelService modelService;

    /**
     * 管理员分页查询模型信息
     *
     * @param modelPageDto 模型信息查询条件
     * @param pageModel    分页模型
     * @return 分页查询结果
     */
    @GetMapping("/page")
    @ControllerLog(description = "管理员查询模型信息", operator = Operator.QUERY)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Page<ModelPageVo>> pageModel(@Validated({GetGroup.class}) ModelPageDto modelPageDto, PageModel pageModel) {
        Page<ModelPageVo> page = modelService.pageModel(modelPageDto, pageModel);
        return R.ok(page);
    }

    /**
     * 管理员添加模型
     *
     * @param modelAddOrUpdateDto 被添加模型信息
     * @return 添加结果
     */
    @PostMapping("/add")
    @ControllerLog(description = "管理员添加模型信息", operator = Operator.INSERT)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> addModel(@RequestBody @Validated({PostGroup.class}) ModelAddOrUpdateDto modelAddOrUpdateDto) {
        if (!ModelTypeService.hasServiceByTypeName(modelAddOrUpdateDto.getType(), modelAddOrUpdateDto.getService())) {
            throw new CustomizeReturnException(ReturnCode.PARAMETER_FORMAT_MISMATCH, "该模型类型不支持该类型服务");
        }
        modelService.addModel(modelAddOrUpdateDto);
        return R.ok("添加成功");
    }

    /**
     * 管理员根据ID删除模型
     *
     * @param id 被删除模型的ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    @ControllerLog(description = "管理员删除模型信息", operator = Operator.DELETE)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> deleteModel(@PathVariable("id") Long id) {
        modelService.deleteModel(id);
        return R.ok("删除成功");
    }

    /**
     * 管理员修改模型信息
     *
     * @param modelAddOrUpdateDto 被修改后的模型信息
     * @return 修改结果
     */
    @PutMapping("/update/info")
    @ControllerLog(description = "管理员修改模型信息", operator = Operator.UPDATE)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> updateInfo(@RequestBody @Validated({PutGroup.class}) ModelAddOrUpdateDto modelAddOrUpdateDto) {
        modelService.updateInfo(modelAddOrUpdateDto);
        return R.ok("修改信息成功");
    }

    /**
     * 管理员修改模型状态
     *
     * @param modelUpdateStateDto 被修改模型的ID对象
     * @return 修改结果
     */
    @PutMapping("/update/state")
    @ControllerLog(description = "管理员修改模型状态", operator = Operator.UPDATE)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<String> updateState(@RequestBody @Validated({PutGroup.class}) ModelUpdateStateDto modelUpdateStateDto) {
        modelService.updateState(modelUpdateStateDto);
        return R.ok("修改状态成功");
    }

    /**
     * 导出模型表格
     *
     * @return 导出表格
     */
    @GetMapping("/export")
    @ControllerLog(description = "管理员导出模型表格", operator = Operator.EXPORT)
    @SaCheckRole(value = {Constants.ROLE_ADMIN})
    public R<Void> exportUser(HttpServletResponse response) {
        List<ModelExportVo> list = modelService.exportExcelList();
        ExcelUtils.exportHttpServletResponse(list, "模型表", ModelExportVo.class, response);
        return R.empty();
    }

}
