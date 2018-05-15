import java.util.Arrays;

public class BitSet {
    private boolean[] bitAr;

    public BitSet(int size) {
        bitAr = new boolean[size];
    }

    public BitSet(String bits) {
        bitAr = new boolean[bits.length()];
        for (int i = 0; i < bits.length(); i++) {
            switch (bits.charAt(i)) {
                case '1':
                    bitAr[i] = true;
                    break;
                case '0':
                    bitAr[i] = false;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public BitSet(boolean[] b) {
        bitAr = new boolean[b.length];
        System.arraycopy(b, 0, bitAr, 0, b.length);
    }

    public BitSet and(BitSet other) {
        if (this.bitAr.length != other.bitAr.length) throw new IllegalArgumentException();
        BitSet res = new BitSet(bitAr.length);
        for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = bitAr[i] && other.bitAr[i];
        return res;
    }

    public BitSet or(BitSet other) {
        if (this.bitAr.length != other.bitAr.length) throw new IllegalArgumentException();
        BitSet res = new BitSet(bitAr.length);
        for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = bitAr[i] || other.bitAr[i];
        return res;
    }

    public BitSet not() {
        BitSet res = new BitSet(bitAr.length);
        for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = !bitAr[i];
        return res;
    }

    public boolean contains(int place) {
        if (0 > place || place > bitAr.length) throw new IndexOutOfBoundsException();
        return bitAr[place];
    }

    public boolean contains(int[] place) {
        for (int elem : place) {
            if(!this.contains(elem))return false;
        }
        return true;
    }

    public boolean add(int place) {
        boolean check=false;
        if (0 > place || place > bitAr.length) throw new IndexOutOfBoundsException();
            if(!bitAr[place]) check = true;
            bitAr[place] = true;
        return check;
    }

    public boolean add(int[] place) {
        boolean check=false;
        for (int elem : place) {
            if(this.add(elem))check = true;
        }
        return check;
    }

    public boolean remove(int place) {
        boolean check=false;
        if (0 > place || place > bitAr.length) throw new IndexOutOfBoundsException();
            if(bitAr[place]) check = true;
            bitAr[place] = false;
        return check;
    }

    public boolean remove(int[] place) {
        boolean check=false;
        for (int elem : place) {
            if(this.remove(elem))check = true;
        }
        return check;
    }

    public boolean[] getBitAr() {
        boolean[] b = new boolean[bitAr.length];
        System.arraycopy(bitAr, 0, b, 0, bitAr.length);
        return b;
    }

    @Override
    public String toString() {
        return Arrays.toString(bitAr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitSet bitSet = (BitSet) o;
        return Arrays.equals(bitAr, bitSet.bitAr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bitAr);
    }
}