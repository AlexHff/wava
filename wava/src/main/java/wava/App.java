package wava;

import java.util.HashMap;
import java.util.Map;

import wava.collections.MapUtils;

public class App {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        Map<String, Integer> rev = MapUtils.reverse(map);
        System.out.println(rev);
    }
}
