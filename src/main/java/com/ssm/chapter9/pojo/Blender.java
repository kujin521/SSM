package com.ssm.chapter9.pojo;

public class Blender {

    public String mix(String water,String fruit,String sugar){
        String juice="这是一杯由液体："+water+"\n水果"+fruit+"\n糖量："+sugar+"\n组成的果汁";
        return juice;
    }

}
