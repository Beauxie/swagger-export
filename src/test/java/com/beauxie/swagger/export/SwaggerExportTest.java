package com.beauxie.swagger.export;

import com.beauxie.swagger.export.utils.StreamTool;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import io.swagger.io.HttpClient;
import org.junit.Test;

import java.io.InputStream;

import static com.beauxie.swagger.export.constants.Constant.*;

/**
 * 将swagger-api文档导出成html
 *
 * @author Beauxie
 * @date Created on 2018/04/06
 */
public class SwaggerExportTest {
    /**
     * 服务器地址
     */
    private static String SERVICE_URL = "http://127.0.0.1:8080";

    static {
        StreamTool.checkFile(OUTPUT_DIR);
    }


    @Test
    public void test() throws Exception {
        outputJson();
        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
        Swagger2MarkupConverter.from(FILE_PATH)
                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
                .withExamples(SNIPPET_DIR)
                .build()
                .intoFolder(OUTPUT_DIR);// 输出

    }

    public void outputJson() throws Exception {
        String url = SERVICE_URL + URI;
        HttpClient httpClient = new HttpClient(url);
        System.out.println("开始请求:" + url);
        InputStream ipputStream = httpClient.execute();
        byte[] data = StreamTool.read(ipputStream);
        System.out.println("请求结果:" + new String(data, "UTF-8"));
        StreamTool.saveDataToFile(data, FILE_PATH);
        System.out.println("请求结果已成功保存到本地:" + FILE_PATH);

    }

}
