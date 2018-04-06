package com.beauxie.swagger.export.utils;

import java.io.*;

/**
 * @author Beauxie
 * @date Created on 2018/04/06
 */
public class StreamTool {
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }

    /**
     * @param data     ：数据
     * @param filePath ：要保存的文件路径，包含文件名及其后缀
     * @author xiepuyao
     */
    public static void saveDataToFile(byte[] data, String filePath) throws IOException {

        OutputStream os = null;
        os = new FileOutputStream(new File(filePath));
        os.write(data, 0, data.length);
        os.flush();// 刷新缓冲区中的内容
        os.close();// 关闭输出流
    }

    public static  void checkFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("已创建目录:" + filePath);
        }
    }
}
