package no.hvl.dat102.kjedet;

public class Entry {
    private int index;
    private Character p;
    
    public Entry(int index, Character p) {
        this.index = index;
        this.p = p;
    }

    public Character getP() {
        return p;
    }

    public void setP(Character p) {
        this.p = p;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}

