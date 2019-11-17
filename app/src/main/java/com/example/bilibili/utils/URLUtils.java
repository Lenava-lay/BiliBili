package com.example.bilibili.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLUtils {

    public static String doGet(String urlStr) {
        HttpURLConnection connection = null;
        InputStream inStream = null;
        BufferedReader reader = null;
        String result = null;


        try {
            //创建远程url连接对象
            URL url = new URL(urlStr);
            //通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            //设置User-Agent
            connection.setRequestProperty("User-agent", "BiLiBiLi Test Client/1.0.0 (718402096@qq.com)");
            //设置连接方式
            connection.setRequestMethod("GET");
            //设置连接主机服务器超时时间
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间
            connection.setReadTimeout(60000);
            //发送请求
            connection.connect();
            //通过connection连接，验证是否请求成功
            if(connection.getResponseCode() == 200) {
                //获取输入流
                inStream = connection.getInputStream();
                //封装输入流inStream，并指定字符集
                reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
                //存放数据
                StringBuffer strBuf = new StringBuffer();
                String temp = null;

                while ((temp = reader.readLine()) != null) {
                    strBuf.append(temp);
                }
                result = strBuf.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //关闭流
            if(inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();

        }
        return result;
    }
}
