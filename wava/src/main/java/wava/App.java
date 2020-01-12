package wava;

import java.util.HashMap;
import java.util.Map;

import wava.collections.MapUtils;

public class App {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2,1);
        Map<Integer, Integer> sortedMap = MapUtils.sortByValue(map, MapUtils.DESC);
        System.out.println(sortedMap);
    }
}
