import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){

        //스캐너로 입력받고 모든공백 제거
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String input = sc.nextLine();
        input = input.replace(" ", "");
        int size = input.length();

        //arrayStack에 입력순서대로 push하기
        ArrayStack In = new ArrayStack(size);
        for(int i=0;i<input.length();i++){
            In.push(input.charAt(i));            
        }
        System.out.print("Input ");
        In.printStack();

        // arrayStack에서 pop해서 다른 스택에 저장 (역순으로 출력) 및 출력
        ArrayStack Out = new ArrayStack(size);
        while(!In.isEmpty()){
            char popChar = In.pop();
            if(popChar =='('){
                popChar = ')';
            }
            else if(popChar ==')'){
                popChar = '(';
            }
            Out.push(popChar);
        }
        
        System.out.print("Output ");
        Out.printStack();

    }
}


interface Stack {
    public int size();
    public boolean isEmpty();
    public char top();
    public char push(char o); 
    public char pop();
}


class ArrayStack implements Stack{
    private char[] data;
    private int top;
 
    public ArrayStack(int size){
        data = new char[size];
        top = -1;
    }
 
    public int size() {
        return top +1;
    }
 
    public boolean isEmpty() {
        return (top == -1);
    }
 
    public char top() {
        return data[top];
    }
 
    public char push(char o) {
        data[++top] = o;
        return 0;
    }
 
    public char pop() {
        if(isEmpty()) {
            System.out.println("Deleting fail! Array Stack is empty!!");
            return 0;
        }
        else{
            return data[top--];
        }

    }
    public void printStack(){
        if(isEmpty())
            System.out.printf("Array Stack is empty!! %n %n");
        else{
            System.out.printf("Array Stack>> ");
            for(int i=0; i<=top; i++)
                System.out.printf("%c ", data[i]);
            System.out.println(); 
            System.out.println();
        }
    }

}