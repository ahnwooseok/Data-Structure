public class Main {

	public static void main(String[] args) {
		
		MyHashTable mht = new MyHashTable(13, 0.9F);
		
		// put test		
		System.out.println("-------------------------------------");
		System.out.println(mht.put("201811032", "HSK"));
		System.out.println(mht.put("201811032", "HSK2"));
		System.out.println(mht.put("201811111", "KDI"));
		System.out.println(mht.put("201811115", "KDP"));
		System.out.println(mht.put("201811215", "DDP"));
		System.out.println(mht.put("201811515", "GDP"));		
		System.out.println(mht.getLoadFactor());			
		
		System.out.println(mht.put("201811515", "LID"));
		System.out.println(mht.put("201911528", "HID"));
		System.out.println(mht.put("201911529", "YID"));
		System.out.println(mht.put("201911530", "YKD"));
		System.out.println(mht.put("201911560", "YHD"));
		System.out.println(mht.getLoadFactor());
		
		// get test
		System.out.println("-------------------------------------");
		System.out.println(mht.get("201811032"));
		System.out.println(mht.get("201811111"));		
		
		// print test		
		mht.printHashTable();
		
		// rehash test
		System.out.println("-------------------------------------");
		System.out.println(mht.put("201912515", "JID"));
		System.out.println(mht.put("201211528", "IJD"));
		System.out.println(mht.put("201916529", "YIJ"));
		System.out.println(mht.put("201917530", "QKD"));
		System.out.println(mht.put("201211560", "YHD"));
		System.out.println(mht.getLoadFactor());
		
		// print test
		mht.printHashTable();
		
		// remove test
		System.out.println("-------------------------------------");
		System.out.println(mht.remove("201211032"));
		System.out.println(mht.remove("201211528"));
		
		// print test
		mht.printHashTable();
				
										

	}

}
