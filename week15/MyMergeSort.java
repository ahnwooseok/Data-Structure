import java.util.ArrayList;
import java.util.Comparator;

public class MyMergeSort {
	
	private ArrayList L1;
	private ArrayList L2;
	private Comparator comp;
	
	// Constructor
	MyMergeSort(Comparator c) {
		this.L1 = new ArrayList();
		this.L2 = new ArrayList();
		this.comp = c;
	}
	
	// sort method - only use 2^?
	public void sort(ArrayList l) {
					
		// scanning 
		this.L1 = (ArrayList)l.clone();
		
		// pre-print
		System.out.println("****** BEFORE SORT ******");
		printListState(l);
		
		int swt = 1;
		ArrayList inputList = null;
		ArrayList outputList = null;		
		
		// size is block size
		for(int size=1; size<l.size(); size=size*2) {
					
			// switch & clear
			if(swt % 2 ==  1) {
				inputList = this.L1;				
				outputList = this.L2;
			}				
			else {
				inputList = this.L2;				
				outputList = this.L1;
			}				
			
			outputList.clear();
						
			// setting
			int i_idx = 0;
			int j_idx = i_idx + size;
			
			
			for(int k=0; k<l.size()/(size*2); k++) {								
							
				// setting idx & size
				int i = i_idx;			
				int j = j_idx;
				int i_size = 0;
				int j_size = 0;
								
				while(i_size < size && j_size < size) {					
					int cmp = this.comp.compare(inputList.get(i), inputList.get(j));
					
					if( cmp < 0 || cmp == 0) {
						// i < j or i == j
						outputList.add(inputList.get(i));
						i++;
						i_size++;
					}					
					else {
						// i > j
						outputList.add(inputList.get(j));
						j++;
						j_size++;
					}										
				}
				
				while(i_size < size) {
					outputList.add(inputList.get(i));
					i++;
					i_size++;
				}
				
				while(j_size < size) {
					outputList.add(inputList.get(j));
					j++;
					j_size++;
				}
				
				// change idx
				i_idx = i_idx + size*2;
				j_idx = j_idx + size*2;							
			}												
			
			swt++;
						
			// temp-print
			System.out.println("****** TEMP SORT ******");
			printListState(outputList);
			
		}
		
		// post-print
		System.out.println("****** AFTER SORT ******");
		printListState(outputList);
		
	}
	
	// normal sort method - even odd
	public void sort2(ArrayList l) {
		
		// scanning 
		this.L1 = (ArrayList)l.clone();
				
		// pre-print
		System.out.println("****** BEFORE SORT ******");
		printListState(l);
		
		int swt = 1;
		boolean oddEvent = false; // check odd Event
		ArrayList inputList = null;
		ArrayList outputList = null;
		
		// size is block size
		for(int size=1; size<l.size(); size=size*2) {
			
			// switch & clear
			if(swt % 2 ==  1) {
				inputList = this.L1;				
				outputList = this.L2;
			}				
			else {
				inputList = this.L2;				
				outputList = this.L1;
			}				
						
			outputList.clear();			
			int start = 0; // merge start idx		
			
			
			while(true) {				
								
				if(oddEvent && (size*2 > l.size())) {
					// odd Event occur & last phase 
					this.merge(inputList, outputList, size, l.size()-size, start);
					break;
				}
				
				this.merge(inputList, outputList, size, size, start);				
				start = start + size*2;				
				
				// check remains 
				int dif = l.size() - outputList.size();
				
				if(dif == 0) {
					// merge complete
					break;
				}
				else if(dif < size*2) {
					// occur odd event
					oddEvent = true;
					
					if(dif <= size) {
						// move remains						
						for(int i=start; i<l.size(); i++) {
							outputList.add(inputList.get(i));
						}												
					}
					else {
						// merge remains
//						System.out.println("size : " + size + ", dif-size : " + (dif-size) + ", start : " + start);
						this.merge(inputList, outputList, size, dif-size, start);						
					}										
					break;
				}
				else {
					// continue
				}
			}
																		
			swt++;														
			
			// temp-print
			System.out.println("****** TEMP SORT ******");
			printListState(outputList);
		}
		
		// post-print
		System.out.println("****** AFTER SORT ******");
		printListState(outputList);
		
	}
	
	// merge method - use 2-arrayList, each size_limit, start index
	public void merge(ArrayList inputList, ArrayList outputList, int i_size_limit, int j_size_limit, int start) {
		
		// setting idx & size
		int i_idx = start;
		int j_idx = i_idx + i_size_limit;
		int i_size = 0;
		int j_size = 0;
		
		while(i_size < i_size_limit && j_size < j_size_limit) {					
			int cmp = this.comp.compare(inputList.get(i_idx), inputList.get(j_idx));
			
			if( cmp < 0 || cmp == 0) {
				// i < j or i == j
				outputList.add(inputList.get(i_idx));
				i_idx++;
				i_size++;
			}					
			else {
				// i > j
				outputList.add(inputList.get(j_idx));
				j_idx++;
				j_size++;
			}										
		}
		
		while(i_size < i_size_limit) {
			outputList.add(inputList.get(i_idx));
			i_idx++;
			i_size++;
		}
		
		while(j_size < j_size_limit) {
			outputList.add(inputList.get(j_idx));
			j_idx++;
			j_size++;
		}											
	}
		
	
	// print List
	public void printListState(ArrayList l) {
		for(int i=0; i<l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println();
	}
	
	// setter
	public Comparator setComparator(Comparator c) {
		this.comp = c;
		return this.comp;
	}
}
