package com.example.blccoin.utils;

import com.csvreader.CsvReader;
import com.example.blccoin.pojo.ChinesePaper;
import com.example.blccoin.pojo.Paper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;


public class CSVHandler {

    static String sqlScriptOutputPath="D:\\AdiCode\\Eureka\\blc-coin\\sql\\data.sql";


    /**
     * 这个方法可以将一个装有paper信息的csv文件转成Paper的ArrayList
     * @param filePath csv文件路径
     * @param mappingFilePath   ccf推荐 对照列表 得出文献分级
     * @return
     */
    public static ArrayList<Paper> getPaperList(String filePath,String mappingFilePath){
        ArrayList<Paper> paperList=new ArrayList<>();
        HashMap<String ,String> map=getLevel(mappingFilePath);
        try {
            // 创建CSV读对象
            Charset charset = StandardCharsets.UTF_8;
            CsvReader csvReader = new CsvReader(filePath,',',charset);
            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                String title = csvReader.get("标题");
                String author = csvReader.get("作者");
                String year = csvReader.get("年份");
                String venue = csvReader.get("来源出版物名称");
                String link = csvReader.get("链接");
                String synopsis=csvReader.get("摘要");
                String keywords=csvReader.get("作者关键字")+csvReader.get("索引关键字");
                String level="非CCF推荐";
                if(map.containsKey(venue)){
                    level=map.get(venue);
                }
                Paper paper=new Paper(null, title, author,year, venue, link, synopsis, keywords,level);
                paperList.add(paper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paperList;
    }

    /**
     * 仅由getPaperList调用
     * @param filePath ccf推荐 对照列表 得出文献分级
     */
    public static HashMap<String,String> getLevel(String filePath){
        HashMap<String,String> map=new HashMap<>();
        try {
            // 创建CSV读对象
            Charset charset = StandardCharsets.UTF_8;
            CsvReader csvReader = new CsvReader(filePath,',',charset);
            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                String venueName = csvReader.get("刊物全称");
                String level = csvReader.get("等级");
                map.put(venueName,level);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 生成SQLScript，方便服务启动时初始化数据库
     * @param papers 文献List
     * @param outputPath 输出脚本路径
     * @param type 0=英文文献表 1=中文文献表
     *
     * 测试后不好用，paper的摘要里会包含"字符，要做特殊处理，否则SQL脚本不能正常使用，现已弃用
     */
    public static void generateSQLScript(ArrayList<Paper> papers, String outputPath,int type){
        BufferedWriter bufferedWriter=null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
            for(Paper paper: papers){
                String temp = "INSERT INTO papers(name,author,year,conference,link,synopsis,keywords,level) VALUES("+paper.CommaSeparatedValue()+");";
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 中文文献csv文件由wos获得，表头字段有所不同，而且不提供关键词
     * @param filePath
     * @param mappingFilePath
     * @return
     */
    public static ArrayList<ChinesePaper> getChinesePaperList(String filePath,String mappingFilePath){
        ArrayList<ChinesePaper> paperList=new ArrayList<>();
        HashMap<String ,String> map=getLevel(mappingFilePath);
        try {
            // 创建CSV读对象
            Charset charset = StandardCharsets.UTF_8;
            CsvReader csvReader = new CsvReader(filePath,',',charset);
            // 读表头
            csvReader.readHeaders();
            int cnt=0;
            while (csvReader.readRecord()){
                String title = csvReader.get("Article Title - Chinese");
                String author = csvReader.get("Authors");
                String year = csvReader.get("Publication Year");
                String venue = csvReader.get("Source Title - Arabic");
                String link = "https://www.webofscience.com/wos/alldb/full-record/"+csvReader.get("UT (Unique ID)");
                String synopsis=csvReader.get("Abstract - Foreign");
//                String keywords=null;
                String level="非CCF推荐";
                if(map.containsKey(venue)){
                    level=map.get(venue);
                }
                ChinesePaper paper=new ChinesePaper(null, title, author,year, venue, link, synopsis, null,level);
                paperList.add(paper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paperList;
    }



    public static void main(String[] args) {
//        System.out.println(getLevel("D:\\AdiFiles\\TempData\\LevelMapping.csv").size());
//        ArrayList<Paper> papers=getPaperList("D:\\AdiFiles\\TempData\\2022.csv","D:\\AdiFiles\\LevelMapping.csv");
//        generateSQLScript(papers,sqlScriptOutputPath,0);
//        System.out.println(getLevel("D:\\AdiFiles\\LevelMapping2.csv"));
        getChinesePaperList("D:\\AdiFiles\\TempData2\\savedrecs.csv","D:\\AdiFiles\\LevelMapping2.csv");

    }

}
