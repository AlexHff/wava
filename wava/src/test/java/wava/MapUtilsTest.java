package wava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import wava.collections.MapUtils;

/**
 * Unit test for MapUtils.
 */
public class MapUtilsTest {
    @Test
    public void testReversibleMap() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 1);
        m.put(2, 2);
        assertTrue(MapUtils.isReversible(m));
    }

    @Test
    public void testNotReversibleMap() {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 2);
        assertTrue(!MapUtils.isReversible(m));
    }
}
