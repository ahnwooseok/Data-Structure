package week3;

public class Question3 {
    static double LinearFib(int n){
        if(n <=1){
            return 1;
        }
        else{
            return LinearFib(n-2) + LinearFib(n-1);
        }
            
        
    }
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            System.out.println(LinearFib(i));
        }
        
    }
}
