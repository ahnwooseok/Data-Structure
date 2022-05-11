import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable {
	
	private ArrayList bucketArray;
	private int bucketCapcity;
	private int totalCnt;
	private float loadFactor;		
	
	public MyHashTable (int intialCapacity) {
		this.bucketArray = new ArrayList();		
		this.bucketCapcity = intialCapacity;
		this.totalCnt = 0;
		
		// init
		for(int i=0; i<intialCapacity; i++) {
			this.bucketArray.add(null);
		}
	}
	
	public MyHashTable (int intialCapacity, float loadFactor) {
		this.bucketArray = new ArrayList();		
		this.bucketCapcity = intialCapacity;
		this.loadFactor = loadFactor;
		this.totalCnt = 0;
		
		// init
		for(int i=0; i<intialCapacity; i++) {
			this.bucketArray.add(null);
		}
	}
	
	public int hashFunc(String k) {		
		int h = 0;
		int a = 33;	
		
		// generation
		for(int i=0; i<k.length(); i++) {
			h = (h << 5) | (h >>> 27);
			h = (int)(k.charAt(i) * Math.pow(a, k.length()-i-1));
		}
		
		// compression
		h = h % this.bucketCapcity;
				
		return h;				
	}		
	
	public int size() {
		return this.totalCnt;
	}
	
	public String get(String k) {		
		int key = this.hashFunc(k);
		String result = null;
		ArrayList tempList = (ArrayList)this.bucketArray.get(key);		
		
		if(tempList == null) {
			System.out.println("this key is empty!");
		}
		else {			
			for(int i=0; i<tempList.size(); i++) {
				StudentInfo temp = (StudentInfo)tempList.get(i);
				if(k.equals(temp.getStudentID())) {
					result = temp.getStudentName();
				}
			}
		}
		
		return result;
	}
	
	public String put(String k, String v) {
		
		if(this.getLoadFactor() > this.loadFactor) {
			System.out.println("need rehash");
			this.rehash(this.bucketCapcity*2);
		}
		
		StudentInfo newStudent = new StudentInfo(k, v);		
		int key = this.hashFunc(k);		
		
		ArrayList tempList = (ArrayList)this.bucketArray.get(key);
		
		this.totalCnt++;		
		
		if(tempList == null) {
			// make list and put object
			ArrayList newList = new ArrayList();
			newList.add(newStudent);
			this.bucketArray.set(key, newList);			
			return null;
		}
		else {
			// already exist object in key
			tempList.add(newStudent);
			StudentInfo temp = (StudentInfo)tempList.get(0);
			return temp.getStudentName();
		}																			
	}
	
	public String remove(String k) {
		int key = this.hashFunc(k);
		String result = null;
		
		ArrayList tempList = (ArrayList)this.bucketArray.get(key);
		
		if(tempList == null) {
			// no object
			System.out.println("this key is empty!");
		}
		else {
			for(int i=0; i<tempList.size(); i++) {
				StudentInfo temp = (StudentInfo)tempList.get(i);
				
				if(k.equals(temp.getStudentID())) {
					StudentInfo removeStudent = (StudentInfo) (tempList).remove(i);
					result = removeStudent.getStudentName();
					this.totalCnt--;									
				}
			}
		}
						
		return result;
							
	}
	
	public void rehash(int capacity) {		
		ArrayList oldList = this.bucketArray;
		
		// init
		this.bucketCapcity = capacity;
		this.bucketArray = new ArrayList();
		for(int i=0; i<this.bucketCapcity; i++) {
			this.bucketArray.add(null);
		}
		this.totalCnt = 0;		
		
		// reinsert old bucket array to new bucket
		for(int i=0; i<oldList.size(); i++) {
			ArrayList temp = (ArrayList)oldList.get(i);
			if(temp != null) {
				for(int j=0; j<temp.size(); j++) {
					StudentInfo tempStudentInfo = (StudentInfo)temp.get(j);
					this.put(tempStudentInfo.getStudentID(), tempStudentInfo.getStudentName());
				}
			}
		}
				
	}
		
	public float getLoadFactor() {
		return (float)this.totalCnt / this.bucketCapcity;
	}
	
	public void printHashTable() {		
		System.out.println("*************** HASH TABLE ***************");
		System.out.println("Capacity : " + this.bucketCapcity + ", Size : " + this.totalCnt + ", LoadFactor : " + this.loadFactor);
		
		for(int i=0; i<this.bucketArray.size(); i++) {
			
			ArrayList tempList = (ArrayList)this.bucketArray.get(i);
			if(tempList == null) {
				System.out.println("[ 0 ]");
			}
			else {
				System.out.print("[ " + tempList.size() + " ] - ");
				for(int j=0; j<tempList.size(); j++) {
					StudentInfo temp = (StudentInfo)tempList.get(j);
					System.out.print(temp.getStudentName() + " ");
				}
				System.out.println();
			}
		}
	}

}
