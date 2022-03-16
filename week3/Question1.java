package week3;

public class Question1 {

    static double power(int x, int n){
        if(n==0){
            return 1;
        }
        else if(n%2==1){
            double y = power(x, (n-1) / 2);
            return x * y * y;
        }
        else{
            double y = power(x, n/ 2);
            return y * y;
        }
    }
    public static void main(String[] args){
        int x = 5;
        int n = 16;

        double answer = power(x,n);
        System.out.println("answer :  " + answer);

        double answer2 = Math.pow(5,16);
        System.out.println("answer2 :  " + answer2);

    }
}