package com.example.boot25test.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.boot25test.pojo.EasyExcelContext;
import org.apache.poi.ss.usermodel.IndexedColors;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * EasyExcelUtils
 *
 * @author dusk
 * @since 13/11/2019
 */
public class EasyExcelUtils {

    /**
     * 本地下载
     *
     * @param easyExcelContext
     */
    public static void excelExtractor(EasyExcelContext easyExcelContext) {
        EasyExcel.write(easyExcelContext.getFilePath(), easyExcelContext.getClazz()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * 将数据写入到流中
     *
     * @param easyExcelContext
     */
    public static void excelOutputStreamExtractor(EasyExcelContext easyExcelContext) {
        EasyExcel.write(getOutputStream(easyExcelContext.getFileName(), easyExcelContext.getHttpResponse()), easyExcelContext.getClazz()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * 忽略参数执行器
     */
    public static void excelExcludeExtractor(EasyExcelContext easyExcelContext) {
        EasyExcel.write(easyExcelContext.getFilePath(), easyExcelContext.getClazz()).excludeColumnFiledNames(easyExcelContext.getExcludeColumnFiledNames()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * include 根据用户传入字段
     */
    public static void excelIncludeExtractor(EasyExcelContext easyExcelContext) {
        EasyExcel.write(easyExcelContext.getFilePath(), easyExcelContext.getClazz()).includeColumnFiledNames(easyExcelContext.getIncludeColumnFiledNames()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * include 单sheet 下载
     */
    public static void excelIncludeExtractorDownLoad(EasyExcelContext easyExcelContext) {
        EasyExcel.write(getOutputStream(easyExcelContext.getFileName(), easyExcelContext.getHttpResponse()), easyExcelContext.getClazz()).includeColumnFiledNames(easyExcelContext.getIncludeColumnFiledNames()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * exclude 单sheet 下载
     *
     * @param content
     * @param fileContent
     * @param excludeColumnFiledNames
     * @param <T>
     */
    public static <T> void excelExcludeExtractorDownLoad(List<T> content, Map<String, ?> fileContent, Set<String> excludeColumnFiledNames, EasyExcelContext easyExcelContext) {
        EasyExcel.write(getOutputStream(easyExcelContext.getFileName(), easyExcelContext.getHttpResponse()), easyExcelContext.getClazz()).excludeColumnFiledNames(easyExcelContext.getExcludeColumnFiledNames()).registerWriteHandler(getCellStyleStrategy()).sheet(easyExcelContext.getSheetName()).doWrite(easyExcelContext.getContent());
    }

    /**
     * 多sheet 写入下载
     *
     * @param content
     * @param fileContent
     */
    public static void excelExtractorSheets(Map<String, List<?>> content, Map<String, ?> fileContent) {
        // 下载本地
        // ExcelWriter excelWriter = EasyExcel.write(fileContent.get("file").toString()).build();
        ExcelWriter excelWriter = EasyExcel.write(getOutputStream(fileContent.get("fileName").toString(), (HttpServletResponse) fileContent.get("httpResponse"))).build();

        // 多数据源同一个sheet
        // content.forEach((key, value) -> excelWriter.write(value, EasyExcel.writerSheet(i, key).registerWriteHandler(getCellStyleStrategy()).head(fileContent.get(key).getClass()).build()));
        int i = 0;
        for (Map.Entry<String, List<?>> entry : content.entrySet()) {
            excelWriter.write(entry.getValue(), EasyExcel.writerSheet(i, entry.getKey()).registerWriteHandler(getCellStyleStrategy()).head(fileContent.get(entry.getKey()).getClass()).build());
            i++;
        }
        excelWriter.finish();
    }


    /**
     * 导出文件时为Writer生成OutputStream
     *
     * @param fileName
     * @param response
     * @return
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-disposition", String.format("attachment; filename=%s", URLEncoder.encode(fileName, StandardCharsets.UTF_8.name())));
            return response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param fileContent
     * @param clazz
     * @param dealDataListener
     * @param <T>
     */
    public static <T> void excelExtractorRead(Object fileContent, Class<T> clazz, AnalysisEventListener<T> dealDataListener) {
        if (fileContent instanceof InputStream) {
            EasyExcel.read((InputStream) fileContent, clazz, dealDataListener).sheet().doRead();
        } else {
            EasyExcel.read(fileContent.toString(), clazz, dealDataListener).sheet().doRead();
        }
    }

    private static HorizontalCellStyleStrategy getCellStyleStrategy() {
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
        headWriteCellStyle.setWrapped(false);
        headWriteCellStyle.setHidden(false);
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 11);
        headWriteCellStyle.setWriteFont(headWriteFont);

        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        return horizontalCellStyleStrategy;
    }
}
