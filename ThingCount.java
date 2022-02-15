//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class ThingCount implements Comparable {
    private int count;
    private Object thing;

    public ThingCount() {

    }

    public ThingCount(Object thang, int cnt) {
        this.thing = thang;
        this.count = cnt;
    }

    public void setThing(Object obj) {
        this.thing = obj;
    }

    public void setCount(int cnt) {
        this.count = cnt;
    }

    public Object getThing() {
        return this.thing;
    }

    public int getCount() {
        return this.count;
    }

    public boolean equals(Object obj) {
        ThingCount other = (ThingCount) obj;
        return (this.count == other.count) & this.thing.equals(other.thing);
    }

    public int compareTo(Object obj) {
        ThingCount other = (ThingCount) obj;
        return Integer.compare(this.count, other.count);
    }

    public String toString() {
        return "" + thing + " - " + count;
    }
}