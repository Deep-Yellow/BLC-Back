package com.example.blcteam.vo;

import com.example.blcteam.po.PersonPO;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PersonVO {
    private Integer id;
    //type: 0=教师 1=博士研究生 2=硕士研究生 3=本科生
    private String type;
    private String introduction;
    private String link;
    private String personName;

    public static final Map<Integer,String> map = new HashMap<>() ;
    static {
        map.put(0,"教师");
        map.put(1,"博士研究生");
        map.put(2,"硕士研究生");
        map.put(3,"本科生");
    }

    public PersonVO(){}

    public PersonVO(Integer id, String type, String introduction, String link, String personName) {
        this.id = id;
        this.type = type;
        this.introduction = introduction;
        this.link = link;
        this.personName = personName;
    }

    public PersonVO(PersonPO personPO){
        this.id=personPO.getId();
        this.type=map.get(personPO.getType());
        this.introduction=personPO.getIntroduction();
        this.personName=personPO.getPersonName();
        this.link=personPO.getLink();
    }

    public PersonPO getPersonPO(){
        Integer type=getType(this.type);
        return new PersonPO(id,type,introduction,link,personName);
    }
    private Integer getType(String value){
        Integer i=null;
        for(Integer getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                i = getKey;
            }
        }
        return i;
    }

}
