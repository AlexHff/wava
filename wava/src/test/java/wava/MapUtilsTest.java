package wava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import wava.utils.MapUtils;

/**
 * Unit test for MapUtils.
 */
public class MapUtilsTest {
    public static final int ASC = 1;
    public static final int DESC = 2;

    @Test
    public void mapIsReversible() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 1);
        m.put(2, 2);
        assertTrue(MapUtils.isReversible(m));
    }

    @Test
    public void mapIsNotReversible() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 2);
        assertTrue(!MapUtils.isReversible(m));
    }

    @Test
    public void sortMapByValueAccordingToNaturalOrdering() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 5);
        m.put(2, 9);
        m.put(3, 1);
        m.put(4, 3);
        m.put(5, 4);
        m.put(6, 6);
        m.put(7, 6);
        m.put(8, 3);
        m.put(9, 2);
        Map<Integer,Integer> sortedMap = new TreeMap<>();
        sortedMap.put(3, 1);
        sortedMap.put(9, 2);
        sortedMap.put(4, 3);
        sortedMap.put(8, 3);
        sortedMap.put(1, 5);
        sortedMap.put(5, 4);
        sortedMap.put(6, 6);
        sortedMap.put(7, 6);
        sortedMap.put(2, 9);
        assertEquals(sortedMap, MapUtils.sortByValue(m));
    }

    @Test
    public void sortMapByValueAccordingToReverseNaturalOrdering() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 5);
        m.put(2, 9);
        m.put(3, 1);
        m.put(4, 3);
        m.put(5, 4);
        m.put(6, 6);
        m.put(7, 6);
        m.put(8, 3);
        m.put(9, 2);
        Map<Integer,Integer> sortedMap = new TreeMap<>();
        sortedMap.put(2, 9);
        sortedMap.put(7, 6);
        sortedMap.put(6, 6);
        sortedMap.put(5, 4);
        sortedMap.put(1, 5);
        sortedMap.put(8, 3);
        sortedMap.put(4, 3);
        sortedMap.put(9, 2);
        sortedMap.put(3, 1);
        assertEquals(sortedMap, MapUtils.sortByValue(m, DESC));
    }

    @Test
    public void reverseMap() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(3, 4);
        Map<Integer,Integer> reversedMap = new TreeMap<>();
        reversedMap.put(2, 1);
        reversedMap.put(4, 3);
        assertEquals(reversedMap, MapUtils.reverse(m));
    }

    @Test
    public void reverseNotReversibleMap() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 2);
        assertEquals(null, MapUtils.reverse(m));
    }
}
