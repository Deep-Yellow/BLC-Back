package com.example.blccoin.utils;


import java.io.File;
import java.util.ArrayList;

public class FileListUtil {

    public static ArrayList<String > getFileList(String rootPath){
        File f = new File(rootPath);
        ArrayList<String> res = new ArrayList<>();
        if (!f.exists()) {
            System.out.println(rootPath + " not exists");//不存在就输出
            return null;
        }
        else{
            File[] fa = f.listFiles();//用数组接收  F:\笔记总结\C#, F:\笔记总结\if语句.txt
            //获取数组中的第i个
            for (File fs : fa) {res.add(fs.getName());}
            return res;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list=getFileList("D:\\AdiFiles\\TempData");
        System.out.println(list);
    }
}
