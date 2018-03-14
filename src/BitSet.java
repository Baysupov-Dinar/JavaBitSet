import java.util.Arrays;

public class BitSet {
    private boolean[] bitAr;

    private BitSet(int size, boolean b) {
        bitAr = new boolean[size];
        if (b) for (boolean a : bitAr) a = true;
        else for (boolean a : bitAr) a = false;
    }

    BitSet(String bits) {
        bitAr = new boolean[bits.length()];
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1' || bits.charAt(i) == '0') bitAr[i] = bits.charAt(i) == '1';
            else throw new IllegalArgumentException();
        }
    }

    public BitSet and(BitSet other) {
        BitSet res = new BitSet(bitAr.length, false);
        if (this.bitAr.length != other.bitAr.length) throw new IllegalArgumentException();
        else for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = bitAr[i] == other.bitAr[i] && bitAr[i];
        return res;
    }

    public BitSet or(BitSet other) {
        BitSet res = new BitSet(bitAr.length, false);
        if (this.bitAr.length != other.bitAr.length) throw new IllegalArgumentException();
        else for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = bitAr[i] != other.bitAr[i] || bitAr[i];
        return res;
    }

    public BitSet xor(BitSet other) {
        BitSet res = new BitSet(bitAr.length, false);
        if (this.bitAr.length != other.bitAr.length) throw new IllegalArgumentException();
        else for (int i = 0; i < bitAr.length; i++) res.bitAr[i] = bitAr[i] != other.bitAr[i];
        return res;
    }

    public BitSet createFromArray(boolean[] b) {
        bitAr = b;
        return this;
    }

    public boolean contains(String elems) {
        boolean b = true;
        for (int i = 0; i < elems.length(); i++) b = bitAr[i] == new BitSet(elems).bitAr[i];
        return b;
    }

    public BitSet add(int place, String elems) {
        BitSet res = new BitSet("1");
        int lE = elems.length();
        int lB = bitAr.length;
        boolean[] tmp = new boolean[lB + lE];
        BitSet t = new BitSet(elems);
        if (place == 0) System.arraycopy(t.bitAr, 0, tmp, 0, lE);
        else {
            System.arraycopy(bitAr, 0, tmp, 0, place);
            System.arraycopy(t.bitAr, 0, tmp, place, lE);
            System.arraycopy(bitAr, place, tmp, place + lE, place);
        }
        return res.createFromArray(tmp);
    }

    public BitSet remove(int place, String elems) {
        BitSet res = new BitSet("1");
        int lE = elems.length();
        int lB = bitAr.length;
        boolean[] tmp = new boolean[lB - lE];
        if (!this.contains(elems)) throw new IllegalArgumentException();
        if (place == 0) System.arraycopy(bitAr, place, tmp, 0, lE);
        else {
            System.arraycopy(bitAr, 0, tmp, 0, place);
            System.arraycopy(bitAr, place + lE, tmp, place, lB - place - lE);
        }
        return res.createFromArray(tmp);
    }

    public boolean[] getBitAr() {
        return bitAr;
    }

    public void setBitAr(boolean[] bitAr) {
        this.bitAr = bitAr;
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