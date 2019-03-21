package com.pigbaby.demo.utils; 

import java.io.IOException; 

import org.apache.http.HttpStatus; 
import org.apache.http.client.methods.CloseableHttpResponse; 
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.impl.client.CloseableHttpClient; 
import org.apache.http.impl.client.HttpClients; 
import org.apache.http.util.EntityUtils; 

/**
 * SourceFile
 */
public class SourceFile {
    public static String getHtml(String url) {
        String html = new String(); 
        HttpGet httpGet = new HttpGet(url); 

        // 模拟浏览器，避免被服务器拒绝，返回返回403 forbidden的错误信息
        httpGet.setHeader("User-Agent", 
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36"); 

        CloseableHttpResponse response = null; 
        CloseableHttpClient client = HttpClients.createDefault(); 

        try {
            response = client.execute(httpGet); 
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                html = EntityUtils.toString(response.getEntity(), "utf-8"); 
            }
        }catch (IOException e) {
            e.printStackTrace(); 
        }finally {
            if (response != null) {
                try {
                    response.close(); 
                }catch (IOException e1) {
                    e1.printStackTrace(); 
                }
            }
        }
        return html; 
    }
}