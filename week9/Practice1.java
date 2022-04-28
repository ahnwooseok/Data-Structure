import java.util.ArrayList;
import java.util.Comparator;


class IntComparator implements Comparator {
 
    public int compare(Object o1, Object o2) {
        return (int)o1 - (int)o2;
    }
}

class MyPQ {

    private ArrayList list;
    private Comparator comparator;

    MyPQ(Comparator comp) {
        this.list = null;
        this.comparator = comp;
    }

    MyPQ(IntComparator intComp) {
        this.list = new ArrayList();
        this.comparator = intComp;
    }

    MyPQ(IntComparator2 intComp) {
        this.list = new ArrayList();
        this.comparator = intComp;
    }

    MyPQ(int initalCapacity, Comparator comp) {
        this.list = new ArrayList(initalCapacity);
        this.comparator = comp;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public MyEntry insert(Object k, Object v) {
        MyEntry entry = new MyEntry(k, v);

        int now = 0;
        int length = list.size();

        for (int i = 0; i < length; i++) {
            MyEntry temp = (MyEntry) list.get(i);
            if (this.comparator.compare(k, temp.getKey()) > 0) {
                now++;
            }
        }
        list.add(now, entry);
        return entry;
    }

    public MyEntry removeMin() {
        return (MyEntry) list.remove(0);
    }

    public MyEntry min() {
        return (MyEntry) list.get(0);
    }

}

interface Entry{
    public void setKey(Object k);
    public void setValue(Object v);
    public Object getKey();
    public Object getValue();
}

class MyEntry implements Entry{
    
    private Object key;
    private Object value;
    
    public MyEntry() {
        this.key = null;
        this.value = null;
    }
    
    public MyEntry(Object k, Object v) {
        this.key = k;
        this.value = v;
    }
    
    public void setKey(Object k) {
        this.key = k;
    }
    
    public void setValue(Object v) {
        this.value = v;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
}

public class Practice1 {
    public static void main(String[] args){
        IntComparator c = new IntComparator();
        MyPQ pq = new MyPQ(c);

        pq.insert(30, null);
        pq.insert(10, null);
        pq.insert(20, null);


        System.out.println((Integer)pq.removeMin().getKey());
        System.out.println((Integer)pq.removeMin().getKey());
        System.out.println((Integer)pq.removeMin().getKey());
    }    
}
