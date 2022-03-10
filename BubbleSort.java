import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {3,6,125,23,41,2,4,1,5,743};

        System.out.println("Before Bubble Sort : " + Arrays.toString(arr));
        

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= temp;
                }

            }
        }

        System.out.println("After Bubble Sort : " + Arrays.toString(arr));
    }
}
