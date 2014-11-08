
public class LLNode implements Node {
	private Comparable data;
	private Node head;
    private Node next;
    private Node prev;
    private static int listCount;
    
    public LLNode() {
    }
    
    public LLNode(Comparable data) {
        this.head = new LLNode();
    	this.data = data;
        this.next = null;
        this.prev = head;
        listCount++;
    }
	public void setData(Comparable data) { 
    	this.data = data;
    }
    public Comparable getData() { 
    	return data; 
    }
    public void setNext(Node next){
    	this.next = (LLNode)next;
    }
    public Node getNext(){
    	return this.next;
    }
	public void setPrev(Node prev) {
		this.prev = (LLNode)prev;
	}
	public Node getPrev() {
		return this.prev;
	}
	
	//returns the start/head of the node
	public Node add(Node thing) {
		LLNode node = (LLNode)thing;
		LLNode current = (LLNode) head;
		//if empty list
		if (listCount == 0) {
			head = node;
			return node;
		}
		//check thing against the head node
		else if (node.data.compareTo(head) < 0) {
			node.setNext(head);
			node.setPrev(node);
			head.setPrev(node);
			head = node;
			listCount++;
			return head;
		}
		//check all items up until the last item
		while (current.next != null) {
			if (node.getData().compareTo(current) > 0) {
				current = (LLNode)current.getNext();
			}
			else {
				node.setPrev(current.prev);
				node.setNext(current);
				current.prev.setNext(node);
				current.setPrev(node);
				listCount++;
				return head;
			}
		}
		//arrive to the end of the list so current.next==null
		if (node.getData().compareTo(current) < 0) {
			node.setNext(current);
			node.setPrev(current.prev);
			current.setPrev(node);
			current.setNext(null);
			listCount++;
			return head;
		}
		else {
			current.setNext(node);
			node.setPrev(current);
			node.setNext(null);
			listCount++;
			return head;
		}
	}
	public Node search(Comparable item) {
		LLNode current = (LLNode) head;
		while (current != null) {
			if (item.compareTo(current.getData()) == 0) {
				return current;
			}
			else current = (LLNode)current.getNext();
		}
		return null;
	}
}
