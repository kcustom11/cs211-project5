public class Person implements Comparable{

	String id;
	
	public Person(String i, int a){
		id = i;
		//age = a;
	}
	
	public String getId(){
		return id;
	}
	
	public int compareTo(Object o){
		if (o == null)
			return 1;
		else
			return id.compareTo(o.toString());
	}
	
	public String toString(){
		return id;
	}
	
	public boolean equals(Object o){
		if (o == null)
			return false;
		return o.toString().equals(id);
	}
}