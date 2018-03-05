import java.util.Objects;
import java.util.Vector;

public class BitSet {
    private Vector<Object> vector;

    public BitSet(Vector<Object> v) {
        this.vector = v;
    }

    public BitSet() {
        this.vector = new Vector<>();
    }

    public BitSet(Object... objs) {
        Vector<Object> res = new Vector<>();
        for (Object o : objs) {
            res.add(o);
        }
        this.vector = res;
    }

    public boolean contains(Object a) {
        return vector.contains(a);
    }

    public void add(Object a) {
        vector.add(a);
    }

    public void remove(Object a) {
        if (vector.contains(a)) {
            vector.remove(a);
        } else {
            System.out.println("error: element is not found");
        }
    }

    public BitSet and(BitSet other) {
        BitSet res = new BitSet();
        for (Object elem : vector) {
            if (other.vector.contains(elem)) {
                res.add(elem);
            }
        }
        return res;
    }

    public BitSet or(BitSet other) {
        BitSet res = new BitSet(other.vector);
        for (Object elem : vector) {
            if (!other.vector.contains(elem)) {
                res.add(elem);
            }
        }
        return res;
    }

    public Vector<Object> getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof BitSet) {
            BitSet obj = (BitSet) other;
            return this.vector.containsAll(obj.getVector());
        }
        return false;
    }

}
