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
    public void xor() {
        BitSet a = new BitSet("1001");
        BitSet b = new BitSet("0011");
        assertEquals(new BitSet("1010"), a.xor(b));
    }

    @Test
    public void createFromArray() {
        BitSet a = new BitSet("1001");
        assertEquals(new BitSet("01"), a.createFromArray(new boolean[]{false, true}));
    }

    @Test
    public void contains() {
        BitSet a = new BitSet("1001");
        assertEquals(true, a.contains("00"));
    }

    @Test
    public void add() {
        BitSet a = new BitSet("1001");
        assertEquals(new BitSet("101101"), a.add(2, "11"));
    }

    @Test
    public void remove() {
        BitSet a = new BitSet("1001");
        assertEquals(new BitSet("11"), a.remove(1, "00"));
    }
}
