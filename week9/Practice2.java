import java.awt.Point;
import java.util.Comparator;



class IntComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        // return (01 > 02 ? (int) o1 : (int) o2);
        return (((double)o1 > (double)o2) ? 1 : (o1 == o2) ? 0 : -1);
    }

}

class IntComparator2 implements Comparator {

    public int compare(Object o1, Object o2) {
        // return (01 > 02 ? (int) o1 : (int) o2);
        return (((double)o1 > (double)o2) ? -1 : (o1 == o2) ? 0 : 1);
    }

}
public class Practice2 {

    public static void main(String[] args) {

        Point[] location = new Point[10];

        location[0] = new Point(5, 4);
        location[1] = new Point(2, 7);
        location[2] = new Point(9, 5);
        location[3] = new Point(3, 1);
        location[4] = new Point(7, 2);
        location[5] = new Point(9, 7);
        location[6] = new Point(1, 4);
        location[7] = new Point(4, 3);
        location[8] = new Point(8, 2);
        location[9] = new Point(4, 8);

        double[] distance = new double[10];
        for (int i = 0; i < 10; i++) {
            distance[i] = Math.sqrt(location[i].getX() * location[i].getX() + location[i].getY() * location[i].getY());
        }

        IntComparator c = new IntComparator();
        MyPQ pq1 = new MyPQ(c);
        for (int i = 0; i < 10; i++) {
            pq1.insert(distance[i], i);
        }
        System.out.println("[가까운 순서]");
        int index;
        char point_name = 97;
        for (int i = 0; i < 10; i++) {
            index = (int) pq1.min().getValue();
            point_name += index;
            System.out.println(point_name + "(" + (int) location[index].getX() + " , " + (int) location[index].getY() + ")");
            point_name = 97;
            pq1.removeMin();
        }
        System.out.println();

        IntComparator2 c2 = new IntComparator2();
        MyPQ pq2 = new MyPQ(c2);
        for (int i = 0; i < 10; i++) {
            pq2.insert(distance[i], i);
        }

        System.out.println("[멀리 있는 순서]");
        for (int i = 0; i < 10; i++) {
            index = (int) pq2.min().getValue();
            point_name += index;
            System.out.println(point_name + "(" + (int) location[index].getX() + " , " + (int) location[index].getY() + ")");
            point_name = 97;
            pq2.removeMin();
        }

    }

}
