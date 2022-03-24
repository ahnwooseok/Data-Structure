public class Q1 {
    public static void main(String[] args){
        int size = 5;
        ArrayStack S = new ArrayStack(size);
        S.push('A');
        S.printStack();
        S.push('B');
        S.printStack();
        S.push('C');
        S.printStack();
        S.push('D');
        S.printStack();
        S.push('E');
        S.printStack();

        char deletedItem = S.pop();
        if(deletedItem != 0) {
            System.out.println("deleted Item: " + deletedItem);
        }
        S.printStack();
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