import org.junit.Test;

import static org.junit.Assert.*;

public class tests {
    @Test
    public void contains(){
        assertEquals(new BitSet(1,2,3,4).contains(3), true);
    }
    @Test
    public void add(){
        BitSet a=new BitSet(1,2,3,4);
        a.add(5);
        assertEquals(a,new BitSet(1,2,3,4,5));

        BitSet b=new BitSet();
        b.add(5);
        assertEquals(b,new BitSet(5));

    }
    @Test
    public void remove(){
        BitSet a=new BitSet(1,2,3,4);
        a.remove(4);
        assertEquals(a,new BitSet(1,2,3));
    }
    @Test
    public void and(){
        BitSet a=new BitSet(1,2,3,4);
        BitSet b=new BitSet(2,3,4,5);
        BitSet c=a.and(b);
        assertEquals(new BitSet(2,3,4),c);
    }
    @Test
    public void or(){
        BitSet a=new BitSet(1,2,3,4);
        BitSet b=new BitSet(2,3,4,5);
        BitSet c=a.or(b);
        assertEquals(new BitSet(1,2,3,4,5),c);
    }
}
