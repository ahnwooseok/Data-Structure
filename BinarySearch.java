public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int iKey = 2;

        int mid = 0;
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            mid = (right + left) / 2;

            if(iKey == arr[mid]){
                System.out.println("the location of "+ iKey +" is "+mid);
                break;
            }
            
            if(iKey <arr[mid])
                right = mid-1;
            else
                left = mid+1;
        }
    }
}
