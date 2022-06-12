import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question1 {
    public static void main(String[] args) throws IOException {

        System.out.println("<Q1>");
        MyMergeSort merge_int = new MyMergeSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });

        ArrayList arr_int = new ArrayList();

        for(int i = 0; i < 20; i++)
            arr_int.add((int)(Math.random() * 100) + 1);

        System.out.println(arr_int);
        merge_int.sort(arr_int);
        System.out.println(arr_int);

        System.out.println("<Q2>");

        File file = new File("./string.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        MyMergeSort merge_string = new MyMergeSort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) < 0)
                    return 1;
                else
                    return 0;
            }
        });

        String[] input_string = br.readLine().split(" ");

        for(int i = 0; i < input_string.length; i++) {
            input_string[i].trim();
            input_string[i] = input_string[i].replace(",", "");
            input_string[i] = input_string[i].replace(".", "");
            input_string[i] = input_string[i].toLowerCase();
        }

        ArrayList arr_str = new ArrayList();
        arr_str.addAll(Arrays.asList(input_string));

        System.out.println(arr_str);
        merge_string.sort(arr_str);
    
    }
}