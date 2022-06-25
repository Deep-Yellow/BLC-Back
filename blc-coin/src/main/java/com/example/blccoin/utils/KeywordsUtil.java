package com.example.blccoin.utils;

import java.util.*;

public class KeywordsUtil {


    public static final Set<String> excludeKeywords = new HashSet<>();
    static {
        excludeKeywords.add("Block-chain");
        excludeKeywords.add("Blockchain");
        excludeKeywords.add("Blockchains");
        excludeKeywords.add("blockchain");
    }

    public static HashMap<String,Integer> count(ArrayList<String> stringArrayList){
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(String s:stringArrayList){
            ArrayList<String> keywords=splitKeywords(s);
            for(String keyword:keywords){
                if(!excludeKeywords.contains(keyword)){
                    hashMap.merge(keyword, 1, Integer::sum);
                }
            }
        }
        return hashMap;
    }

    private static ArrayList<String> splitKeywords(String str){
        ArrayList<String> res=new ArrayList<>();
        String[] temp=str.split(";");
        for(String s:temp){
            res.add(s.trim());
        }
        return res;
    }



    public static void main(String[] args) {
//        ArrayList<String> arrayList=new ArrayList<>();
//        arrayList.add("123;456;789");
//        arrayList.add("456;789;012");
//        arrayList.add("789;116");
//        count(arrayList);
    }
}
