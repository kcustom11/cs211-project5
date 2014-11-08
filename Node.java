public interface Node{
	
	public Comparable getData();
	
	public Node add(Node thing);
		
	public Node search(Comparable item);
	
	public void setNext(Node next);
	
	public void setPrev(Node prev);
	
	
}