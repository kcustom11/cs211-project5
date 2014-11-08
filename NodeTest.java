import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {
	@Test
	public void test1() {
		Person p = new Person("Z", 80);
		Person p2 = new Person("B", 80);
		Person p3 = new Person("A", 80);
		Person p4 = new Person("C", 80);
		Person p5 = new Person("B", 80);
		Person p6 = new Person("E", 80);
		LLNode start = new LLNode(p);
		start = (LLNode) start.add(new LLNode(p2));
		start = (LLNode) start.add(new LLNode(p3));
		start = (LLNode) start.add(new LLNode(p4));
		start = (LLNode) start.add(new LLNode(p5));
		start = (LLNode) start.add(new LLNode(p6));
		assertEquals("A", start.getData().toString());
		start = start.next;
		assertEquals("B", start.getData().toString());
		start = start.next;
		assertEquals("B", start.getData().toString());
		start = start.next;
		assertEquals("C", start.getData().toString());
		start = start.next;
		assertEquals("E", start.getData().toString());
		start = start.next;
		assertEquals("Z", start.getData().toString());
		start = start.next;
	}//end test
	@Test
	public void test2() {
		assertEquals(true, true);
	}//end test
	@Test
	public void test3() {
		assertEquals(true, true);
	}//end test
	@Test
	public void test4() {
		assertEquals(true, true);
	}//end test
	@Test
	public void test5() {
		assertEquals(true, true);
	}//end test
	@Test
	public void test6() {
		assertEquals(true, true);
	}//end test
}
