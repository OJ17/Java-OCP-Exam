package ch4FunctionalProgramming;

import java.util.HashMap;
import java.util.Map;

public class StreamWork {

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);

        
        map.values().stream().peek(System.out::print).forEach(System.out::print);
    }
}
