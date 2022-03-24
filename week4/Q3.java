public class Q3 {
    public static void main(String[] args){
        StackQueue Q =  new StackQueue();

        System.out.println("a-e enqueue");
        for(int i=97;i<102;i++){
            Q.enqueue((char)i);
        }

        System.out.println("3 char dequeue");
        for(int i=0;i<3;i++){
            System.out.println("dequeue : " + Q.dequeue());
        }

        System.out.println("f-j enqueue");
        for(int i=102;i<107;i++){
            Q.enqueue((char)i);
        }
        
        System.out.println("3 char dequeue");
        for(int i=0;i<3;i++){
            System.out.println("dequeue : " + Q.dequeue());
        }

        System.out.println("k-o enqueue");
        for(int i=107;i<112;i++){
            Q.enqueue((char)i);
        }

        System.out.println("6 char dequeue");
        for(int i=0;i<6;i++){
            System.out.println("dequeue : " + Q.dequeue());
        }

        // System.out.println(Q.front());
        // System.out.println(Q.isEmpty());
        

        System.out.println("left char dequeue");
        while(!Q.isEmpty()){
            System.out.println("dequeue : " + Q.dequeue());
        }


    }
}

interface Queue {
    public int size();
    public boolean isEmpty();
    public char front();
    public void enqueue(char o);
    public char dequeue();
}
class StackQueue implements Queue{
    ArrayStack inStack = new ArrayStack(20);
    ArrayStack outStack = new ArrayStack(20);

    public int size(){
        return inStack.size() + outStack.size();
    }

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }
    public char front(){
        if(isEmpty()){
            System.out.println("Queus is empty");
            return 0;
        }
        else if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.top();
        }
        else{
            return outStack.top();
        }

    }
    
    public void enqueue(char o){
        inStack.push(o);
    }

    public char dequeue(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
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