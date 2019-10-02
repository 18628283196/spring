package com.itheima;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("1", "22");
        map.put("2","28" );

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" "+value);
        }

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(map.get(next));
        }
        //System.out.println(result);
    }
}
