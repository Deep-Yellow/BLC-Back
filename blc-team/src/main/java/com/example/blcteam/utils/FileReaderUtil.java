package com.example.blcteam.utils;

import com.example.blcteam.po.PaperPO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<PaperPO> test(){
        ArrayList<PaperPO> res = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdiFiles\\paperInfo2.txt"));
            do {
                String author = br.readLine();
                String name = br.readLine();
                String year = br.readLine();
                String conference = br.readLine();
                String synopsis = br.readLine();
                String link = br.readLine();
                PaperPO paperPO = new PaperPO(null, name, author, year, conference, link, synopsis, null);
                res.add(paperPO);
            } while (br.readLine() != null);
        } catch (IOException e){
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
