import java.util.*;

public class Driver{

	private static Random random = new Random();
	private static int place = -1;
	private static final String WALDO = "50000Kinga";
	private static final int MAX_SIZE = 10000;

	public static void main(String[] args){
		place = random.nextInt(MAX_SIZE-1);
		
		//a sorted linked list
		Node start = runLLAdd();

		//an unsorted ArrayList
		ArrayList list = runArrayListAdd(false);
		
		//a sorted array that doubles in size every time we need to add
		Person[] small = runArrayAdd();	
		
		//an sorted ArrayList
		ArrayList sortedList = runArrayListAdd(true);		
		
		runLLSearch(start);	
		runArrayListSearch(list,false);	
		runArraySearch(small);		
		runArrayListSearch(sortedList,true);				
	}				
		
	public static Node runLLAdd(){
		Person p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
		
		long begin = System.nanoTime();
		Node start = new LLNode(p);
		for (int i = 0; i < MAX_SIZE; i++){
			p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
			if (i == place){
				p = new Person(WALDO, random.nextInt(80));
				System.out.println("seeded waldo");
			}
			try{
				start = start.add(new LLNode(p));
			}catch (StackOverflowError e){
				System.out.println("stack overflowed at " + i);
				i = MAX_SIZE;
			}
			//System.out.println(start.print());
		}
		long end = System.nanoTime();
		System.out.println( "done adding "+MAX_SIZE+" people in sorted linked list in \t\t" + (end-begin));
		return start;
	}
				
	public static void runLLSearch(Node start){
		Person p = new Person(WALDO, random.nextInt(80));
		long begin = System.nanoTime();
		Node found =  start.search(p);
		long end = System.nanoTime();	
		System.out.println( "done searching linked list for " + found.toString() + " in \t\t" + (end-begin));
	}	
	
	public static ArrayList runArrayListAdd(boolean sort){
		Person p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
		String msg = "unsorted";
		if (sort)
			msg = "sorted";
		
		long begin = System.nanoTime();
		ArrayList list = new ArrayList();
		for (int i = 0; i < MAX_SIZE; i++){
			p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
			if (i == place)
				p = new Person(WALDO, random.nextInt(80));
			list.add(p);
			if (sort)
				Collections.sort(list);
		}
		long end = System.nanoTime();
		System.out.println( "done adding "+MAX_SIZE+" people in "+msg+" ArrayList in \t\t" + (end-begin));
		return list;
	}
					
	public static void runArrayListSearch(ArrayList list, boolean sorted){
		Person p = new Person(WALDO, random.nextInt(80));
		String msg = "unsorted";
		if (sorted)
			msg = "sorted";
		
		long begin = System.nanoTime();
		int found = list.indexOf(p);
		long end = System.nanoTime();	
		System.out.println( "done searching "+msg+"ArrayList for " + found + " in \t\t\t" + (end-begin));
	}
	
	public static Person[] runArrayAdd(){
		Person p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
		
		long begin = System.nanoTime();
		Person[] array = new Person[10];
		for (int i = 0; i < MAX_SIZE; i++){
			p = new Person(""+random.nextInt(MAX_SIZE), random.nextInt(80));
			if (i == place)
				p = new Person(WALDO, random.nextInt(80));
			if (i < array.length)
				array[i] = p;
			else{
				Person[] newArray = new Person[array.length * 2];
				for (int n = 0; n < newArray.length; n++)
					if (n < array.length)
						newArray[n] = array[n];
					else
						newArray[n] = new Person("",-1);
				newArray[i] = p;
				array = newArray;
			}
		}
		long end = System.nanoTime();
		System.out.println( "done adding "+MAX_SIZE+" people in unsorted small array in \t\t" + (end-begin));
		return array;
	}	
	
	public static void runArraySearch(Person[] small){
		Person p = new Person(WALDO, random.nextInt(80));
		
		long begin = System.nanoTime();	
		Arrays.sort(small);
		int first = 0;
		int upto = small.length;
		boolean found = false;
		int mid = -1;
    	while (first < upto && !found) {
         	mid = (first + upto) / 2;  // Compute mid point.
        	if (p.compareTo(small[mid]) < 0) 
            	upto = mid;     // repeat search in bottom half.
        	else if (p.compareTo(small[mid]) > 0) 
            	first = mid + 1;  // Repeat search in top half.
        	else 
            	found = true;     // Found it. return position
    	}
		long end = System.nanoTime();     	
     	System.out.println( "done searching sorted small array for  " + mid + " in \t\t" + (end-begin));
	}

}	