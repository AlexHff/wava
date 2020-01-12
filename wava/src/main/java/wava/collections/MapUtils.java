package wava.collections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * MapUtil
 */
public final class MapUtils {
    public static final int ASC = 1;
    public static final int DESC = 2;

    /**
     * Sorts the specified map into ascending order, according to the Comparable
     * natural ordering of its values. All elements in the map value set must
     * implement the Comparable interface. Furthermore, all elements in the value
     * set must be mutually comparable (that is, e1.compareTo(e2) must not throw a
     * ClassCastException for any elements e1 and e2 in the value set).
     * 
     * @param m the map to be sorted
     * @return sorted map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> m) {
        return m.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Sorts the specified map into the order specified by the constant, according
     * to the Comparable natural ordering of its values. All elements in the map
     * value set must implement the Comparable interface. Furthermore, all elements
     * in the value set must be mutually comparable (that is, e1.compareTo(e2) must
     * not throw a ClassCastException for any elements e1 and e2 in the value set).
     * 
     * @param m
     * @param order
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> m,
            final int order) {
        if (order == 1) {
            return sortByValue(m);
        }
        return m.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}