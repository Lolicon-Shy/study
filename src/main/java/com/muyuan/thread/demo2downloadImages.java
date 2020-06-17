package com.muyuan.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class demo2downloadImages extends Thread{

    private String URL;

    private String name;

    public demo2downloadImages(String url, String name){
        this.URL=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(URL,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        demo2downloadImages demo2downloadImages = new demo2downloadImages("http://img2.100bt.com/upload/ttq/20120831/1346406991679.jpg","1.jpg");
        demo2downloadImages demo3 = new demo2downloadImages("https://p1.ssl.qhimgs1.com/sdr/400__/t01957905caa85aefb7.jpg","2.jpg");
        demo2downloadImages demo4= new demo2downloadImages("https://p3.ssl.qhimgs1.com/sdr/400__/t01250737a2a3e235e3.jpg","3.jpg");
        demo2downloadImages demo5 = new demo2downloadImages("https://p1.ssl.qhimgs1.com/sdr/400__/t01c537bfceb421fc6b.jpg","4.jpg");

        demo2downloadImages.start();
        demo3.start();
        demo4.start();
        demo5.start();
    }
}

class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException e) {
            System.out.println("URL有问题");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Io异常，dowloader方法出问题了");
            e.printStackTrace();
        }
    }
}
