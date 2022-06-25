package com.example.blccoin.pojo;

import lombok.Data;

@Data
public class PaperQuery {
    private String keyword;
    private String[] level;
    private String[] year;
    private String wordInTitle;

    public PaperQuery(String keyword, String[] level, String[] year, String wordInTitle) {
        this.keyword = keyword;
        this.level = level;
        this.year = year;
        this.wordInTitle=wordInTitle;
    }

    public static PaperQuery initPaperQueryByWordInTitle(String[] level, String[] year, String wordInTitle){
        return new PaperQuery(null,level,year,wordInTitle);
    }


    public PaperQuery(String keyword, String[] level, String[] year) {
        this.keyword = keyword;
        this.level = level;
        this.year = year;
    }

    public PaperQuery() {
    }
}
