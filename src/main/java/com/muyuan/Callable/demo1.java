package com.muyuan.Callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

public class demo1 implements Callable<Boolean> {

    private String url;
    private String name;

    public demo1(String url, String name) {
        this.url = url;
        this.name = name;
    }



    public Boolean call() throws Exception {
        WebDownloader3 downloader3 = new WebDownloader3();
        downloader3.downloader(url,name);
        System.out.println("下载的文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demo1 demo1 = new demo1("http://img2.100bt.com/upload/ttq/20120831/1346406991679.jpg","1.jpg");
        demo1 demo2 = new demo1("https://p1.ssl.qhimgs1.com/sdr/400__/t01957905caa85aefb7.jpg","2.jpg");
        demo1 demo3 = new demo1("https://p3.ssl.qhimgs1.com/sdr/400__/t01250737a2a3e235e3.jpg","3.jpg");

        ExecutorService ser= Executors.newFixedThreadPool(3);

        Future<Boolean> future = ser.submit(demo1);
        Future<Boolean> future2 = ser.submit(demo2);
        Future<Boolean> future3 = ser.submit(demo3);

        Boolean aBoolean = future.get();
        Boolean aBoolean2 = future2.get();
        Boolean aBoolean3 = future3.get();

        ser.shutdownNow();

    }
}

class WebDownloader3{
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
