package com.muyuan.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class demo4downloadImagesByRun implements Runnable{

    private String URL;

    private String name;

    public demo4downloadImagesByRun(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

    public void run() {
        WebDownloader2 downloader2 = new WebDownloader2();
        downloader2.downloader(URL,name);
        System.out.println("下载的文件名为："+name);
    }

    public static void main(String[] args) {
        demo4downloadImagesByRun demo4 = new demo4downloadImagesByRun("http://img2.100bt.com/upload/ttq/20120831/1346406991679.jpg","1.jpg");
        demo4downloadImagesByRun demo6 = new demo4downloadImagesByRun("https://p1.ssl.qhimgs1.com/sdr/400__/t01957905caa85aefb7.jpg","2.jpg");
        demo4downloadImagesByRun demo7 = new demo4downloadImagesByRun("https://p3.ssl.qhimgs1.com/sdr/400__/t01250737a2a3e235e3.jpg","3.jpg");
        demo4downloadImagesByRun demo9 = new demo4downloadImagesByRun("https://p1.ssl.qhimgs1.com/sdr/400__/t01c537bfceb421fc6b.jpg","4.jpg");
        new Thread(demo4).start();
        new Thread(demo6).start();
        new Thread(demo7).start();
        new Thread(demo9).start();
    }
}


class WebDownloader2{
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
