package com.UDP;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://img.bizhiku.net/uploads/2022/0710/garzhhp11ea.jpg?OSSAccessKeyId=LTAIOUlcvAIvkgqk&Expires=1661949160&Signature=mU0ocpr14T%2BP%2FQ7Y1k7e6XE%2FV5M%3D");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("d://yal.jpg"));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
                out.flush();
            }
            in.close();
            out.close();
            System.out.println("下载成功");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
