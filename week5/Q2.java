public class Q2 {
	public static void main(String[] args) throws Exception{
        System.out.println("this is stack using MyArrayList");
		MyStack stack = new MyStack();
		for(int i=1;i<=10;i++){
            stack.push(i);
        }
        for(int i=1;i<=10;i++){
            System.out.print("pop"+i+" : " + stack.pop());
            System.out.println("");
        }
        // System.out.println(stack.top()); -> exception

        System.out.println("");
        System.out.println("this is queue using MyArrayList");
        MyQueue queue = new MyQueue();
		for(int i=1;i<=10;i++){
            queue.enqueue(i);
        }
        for(int i=1;i<=10;i++){
            System.out.print("dequeue"+i+" : " + queue.dequeue());
            System.out.println("");
        }
        // System.out.println(queue.front()); -> exception
	}
}


class MyArrayList<T> {
    Object[] arr = null;
    int capacity = 0;
    int size = 0;
    
    public MyArrayList(int capacity){
        this.capacity = capacity;
    	arr = new Object[capacity];
        size = 0;
    }
    
    public MyArrayList(){
        capacity = 1;
    	arr = new Object[capacity];
        size = 0;
    }
    
    public void add(T element){
        if(size == capacity){
            expandArray();
        }
        
        arr[size++] = element;
    }
    
    public void addFirst(T element){
        add(0, element);
    }
    
    public void add(int index, T element){
        if(size == capacity){
            expandArray();
        }
        
        for(int i = size; i >= index; i--) 
        	arr[i] = arr[i-1];
        
        arr[index] = element;
        size++;
    }
    
    private void expandArray(){
        capacity *= 2;
        Object[] tempArr = new Object[capacity];
        copyArr(tempArr, arr);
        arr = new Object[capacity];
        copyArr(arr, tempArr);
    }
    
    private void copyArr(Object[] arr1, Object[] arr2){
        for(int i = 0; i < arr2.length; i++){
            arr1[i] = arr2[i];
        }
    }
    
    public T get(int index){
        if(size <= 0){
            System.out.println("배열이 비어있습니다.");
            return null;
        }
        
        return (T) arr[index];
    }
    
    public T remove(int index){
        /*
            크기 초과, 이미 비어있는지 등 조건문은 원하는대로 추가해주면 된다.
        */
        T result = (T) arr[index];
        arr[index] = null;
        size--;
        if(size > 0) {
        /*
        	삭제한 이후부터 앞으로 한칸씩 땡긴다.
        */
        	for(int i = index; i < size; i++) {
        		arr[i] = arr[i+1];
        	}
        }
        
        
        return result;
    }
    public void reset(){
        arr = new Object[capacity];
        size = 0;
    }
    
    public int size() {
    	return this.size;
    }
    
    public int getCapacity() {
    	return this.capacity;
    }
    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }
}



class MyStack{
    MyArrayList<Integer> arr = new MyArrayList<Integer>();

    public int size(){
        return arr.size();
    }
    public boolean isEmpty(){
        return arr.isEmpty();
    }
    public int top() throws Exception{
        Exception enableException = new Exception("empty stack!!");
        if(arr.isEmpty()){
            throw enableException;
        }
        return arr.get(arr.size() - 1);
    }
    public void push(int o) throws Exception{
        arr.add(o);
    } 
    public int pop() throws Exception{
        Exception enableException = new Exception("empty stack!!");
        if(arr.isEmpty()){
            throw enableException;
        }
        int ret = arr.remove(arr.size()-1);
        return ret;
    }
}

class MyQueue{
    MyArrayList<Integer> arr = new MyArrayList<Integer>();

    public int size(){
        return arr.size();
    }
    public boolean isEmpty(){
        return arr.isEmpty();
    }
    public int front() throws Exception{
        Exception enableException = new Exception("empty queue!!");
        if(arr.isEmpty()){
            throw enableException;
        }
        else{
            return arr.get(0);
        }
    }
    public void enqueue(int o) throws Exception{
        arr.add(o);
    } 
    public int dequeue() throws Exception{
        Exception enableException = new Exception("empty queue!!");
        if(arr.isEmpty()){
            throw enableException;
        }
        else{
            int ret = arr.remove(0);
            return ret;
        }
    }
}