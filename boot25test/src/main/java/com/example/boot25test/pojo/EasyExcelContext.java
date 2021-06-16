package com.example.boot25test.pojo;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * EasyExcelCentext
 *
 * @author dusk
 * @since 12/05/2020
 */
public class EasyExcelContext<T> {

    private String filePath;

    private String fileName;

    private String sheetName;

    // 忽略参数
    private List<String> excludeColumnFiledNames;

    // 包含参数
    private List<String> includeColumnFiledNames;

    private HttpServletResponse httpResponse;

    private List<T> content;

    private Class<T> clazz;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<String> getExcludeColumnFiledNames() {
        return excludeColumnFiledNames;
    }

    public void setExcludeColumnFiledNames(List<String> excludeColumnFiledNames) {
        this.excludeColumnFiledNames = excludeColumnFiledNames;
    }

    public List<String> getIncludeColumnFiledNames() {
        return includeColumnFiledNames;
    }

    public void setIncludeColumnFiledNames(List<String> includeColumnFiledNames) {
        this.includeColumnFiledNames = includeColumnFiledNames;
    }

    public HttpServletResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpServletResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}

