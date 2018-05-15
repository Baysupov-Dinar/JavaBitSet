import org.junit.Test;

import static org.junit.Assert.*;

public class tests {
    @Test
    public void and() {
        BitSet a = new BitSet("101");
        BitSet b = new BitSet("111");
        assertEquals(a.and(b), new BitSet("101"));
    }

    @Test
    public void or() {
        BitSet a = new BitSet("101");
        BitSet b = new BitSet("001");
        assertEquals(a.or(b), new BitSet("101"));
    }

    @Test
    public void not() {
        BitSet a = new BitSet("1001");
        assertEquals(new BitSet("0110"), a.not());
    }

    @Test
    public void createFromArray() {
        BitSet a = new BitSet("1001");
        assertEquals(new BitSet("01"), new BitSet(new boolean[]{false, true}));
    }

    @Test
    public void contains() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.contains(0));
    }

    @Test
    public void containsAr() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.contains(new int[]{0,3}));
        BitSet b = new BitSet("1001");
        assertEquals(false, b.contains(new int[]{1,3}));
        BitSet c = new BitSet("1001");
        assertEquals(false, c.contains(new int[]{1,2}));
    }

    @Test
    public void add() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.add(1));
    }

    @Test
    public void addAr() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.add(new int[]{1,2}));
        BitSet b = new BitSet("1001");
        assertEquals(false, b.add(new int[]{0,3}));
        BitSet c = new BitSet("1001");
        assertEquals(true, c.add(new int[]{0,2}));
    }
    @Test
    public void remove() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.remove(0));
    }

    @Test
    public void removeAr() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.remove(new int[]{0,3}));
        BitSet b = new BitSet("1001");
        assertEquals(false, b.remove(new int[]{1,2}));
    }
}