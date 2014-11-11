
public class LLNode implements Node {
	private Comparable data;
	//private LLNode head;
	public LLNode next;
	private LLNode prev;
	
	public LLNode() {}
	
	public LLNode(Comparable data) {
		//this.head = this;
		this.data = data;
		this.next = null;
		this.prev = this;
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
		return (Node)this.next;
	}
	public void setPrev(Node prev) {
		this.prev = (LLNode)prev;
	}
	public Node getPrev() {
		return (Node)this.prev;
	}

	//returns the start/head of the node
	@SuppressWarnings("unchecked")
	public Node add(Node thing) {
		LLNode node = (LLNode)thing;
		LLNode current = this;
		//count backwards to find the head node. save it for later
		while (current.prev != current)
			current = current.prev;
		LLNode head = current;
		//check thing against the head node
		if (node.getData().compareTo(head.getData()) <= 0) {
			node.setNext(head);
			node.setPrev(node);
			head.setPrev(node);
			head = node;
			return head;
		}
		//check all items up until the last item
		while (current.next != null) {
			if (node.getData().compareTo(current.getData()) >= 0) {
				current = (LLNode)current.getNext();
			}
			else {
				node.setPrev(current.prev);
				node.setNext(current);
				current.prev.setNext(node);
				current.setPrev(node);
				return head;
			}
		}
		//arrive to the end of the list so current.next==null
		if (node.getData().compareTo(current.getData()) <= 0) {
			node.setNext(current);
			node.setPrev(current.prev);
			current.prev.setNext(node);
			current.setPrev(node);
			return head;
		}
		else {
			current.setNext(node);
			node.setPrev(current);
			node.setNext(null);
			return head;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Node search(Comparable item) {
		LLNode current = this;
		//count backwards to find the head node. save it for later
		while (current.prev != current)
			current = current.prev;
		while (current != null) {
			if (item.compareTo(current.getData()) == 0) {
				return current;
			}
			else current = (LLNode)current.getNext();
		}
		return null;
	}

	public static void main(String args[]) {
		Person p = new Person("A", 80);
		Person p2 = new Person("B", 80);
		Person p3 = new Person("C", 80);
		Person p4 = new Person("D", 80);
		Person p5 = new Person("E", 80);
		System.out.println(p3.compareTo(p));
		LLNode start = new LLNode(p);
		start = (LLNode) start.add(new LLNode(p2));
		start = (LLNode) start.add(new LLNode(p3));
		start = (LLNode) start.add(new LLNode(p4));
		start = (LLNode) start.add(new LLNode(p5));
		System.out.println(start.getData().toString());
		start = (LLNode) start.getNext();
		System.out.println(start.getData().toString());
		start = (LLNode) start.getNext();
		System.out.println(start.getData().toString());
		start = (LLNode) start.getNext();
		System.out.println(start.getData().toString());
		start = (LLNode) start.getNext();
		System.out.println(start.getData().toString());
		start = (LLNode) start.getNext();
		System.out.println(start.getData().toString());
	}
}
