# swagger-export
该项目的作用是根据swagger在线api生成离线api文档。

# 说明
* 只适用于集成swagger框架的项目
* 确保项目的`/v2/api-docs`接口可访问
* 目前离线文档只支持`html5`格式，如果需要转化为`doc`或`pdf`格式，可以将生成的`html5`文件选择用world文档打开，然后选择'另存为'其他格式。（**建议采用`html`格式，效果最好**）

# 大致思路
 + 1.通过http请求访问swagger相关接口：`/v2/api-docs`,将获取到的json数据保存至项目的`target/asciidoc`目录下，文件名为`swagger.json`；
 + 2.读取上步中保存的`swagger.json`文件，转换为html形式的接口文档。

# 注意

该项目不需要运行任何程序，只需要修改`SwaggerExportTest.java`文件，然后执行相关mvn命令即可。

# 使用

该项目主要类只有一个，包括配置也是在该类中配置，即:
`src\test\java\com\beauxie\swagger\export`下的`SwaggerExportTest.java`测试类


* 配置URL
 修改服务器地址,比如api接口访问地址为`http://127.0.0.1:8080/v2/api-docs`,则如下配置:

``` java
  /**
     * 服务器地址
     */
    private static String SERVICE_URL = "http://127.0.0.1:8080";
```
* 生成文档

修改url地址以后，在项目根目录下打开cmd命令窗口，执行以下mvn命令:
```
mvn test

```

* 文件位置
 执行成功以后，会在项目的`target/asciidoc/html`目录下，生成一个名为`index.html`文件，这个文件就是swagger离线api文档，用浏览器打开即可查看。


**相关博客:**[使用springfox-staticdocs生成swagger离线api](https://blog.csdn.net/BeauXie/article/details/79835396)

