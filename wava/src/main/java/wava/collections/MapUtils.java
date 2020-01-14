package wava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
        List<Entry<K, V>> list = new ArrayList<>(m.entrySet());
        list.sort(Entry.comparingByValue());
        Map<K, V> s = new LinkedHashMap<>();
        for (Entry<K, V> e: list)
            s.put(e.getKey(), e.getValue());
        return s;
    }

    /**
     * Sorts the specified map into the order specified by the constant, according
     * to the Comparable natural ordering of its values. All elements in the map
     * value set must implement the Comparable interface. Furthermore, all elements
     * in the value set must be mutually comparable (that is, e1.compareTo(e2) must
     * not throw a ClassCastException for any elements e1 and e2 in the value set).
     * 
     * @param m     the map to be sorted
     * @param order integer specifying the sorting order
     * @return sorted map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> m,
            final int order) {
        if (order != 2)
            sortByValue(m);
        List<Entry<K, V>> list = new ArrayList<>(m.entrySet());
        list.sort(Collections.reverseOrder(Entry.comparingByValue()));
        Map<K, V> s = new LinkedHashMap<>();
        for (Entry<K, V> e: list)
            s.put(e.getKey(), e.getValue());
        return s;
    }

    /**
     * Sorts the specified map according to the order induced by the specified
     * comparator. All elements in the map value set must implement the Comparable
     * interface. Furthermore, all elements in the value set must be mutually
     * comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for
     * any elements e1 and e2 in the value set).
     * 
     * @param m the map to be sorted
     * @param c the comparator to determine the order of the map. A null value
     *          indicates that the elements' natural ordering should be used
     * @return sorted map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> m,
            Comparator<? super Entry<K, V>> c) {
        List<Entry<K, V>> list = new ArrayList<>(m.entrySet());
        list.sort(c);
        Map<K, V> s = new LinkedHashMap<>();
        for (Entry<K, V> e: list)
            s.put(e.getKey(), e.getValue());
        return s;
    }
}