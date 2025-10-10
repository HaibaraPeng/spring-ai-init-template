package com.example.config.easyexcel.convert.intNum;


import cn.idev.excel.converters.Converter;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author Peng
 * @date 2025-10-10 16:28
 */
public class ExcelByteConverter implements Converter<Byte> {

    @Override
    public Class<Byte> supportJavaTypeKey() {
        return Byte.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 读Excel时转换方法
     */
    @Override
    public Byte convertToJavaData(ReadCellData cellData, ExcelContentProperty contentProperty,
                                  GlobalConfiguration globalConfiguration) {
        String stringValue = cellData.getStringValue();
        if (StringUtils.isEmpty(stringValue)) {
            return null;
        }
        return Byte.parseByte(stringValue);
    }

    /**
     * 写Excel时转换方法
     */
    @Override
    public WriteCellData<Object> convertToExcelData(Byte value, ExcelContentProperty contentProperty,
                                                    GlobalConfiguration globalConfiguration) {
        WriteCellData<Object> cellData = new WriteCellData<>(new BigDecimal(value));
        cellData.setType(CellDataTypeEnum.NUMBER);
        return cellData;
    }

}
