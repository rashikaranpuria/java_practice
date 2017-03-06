
public class LinkedList {

	Node head;
	
	LinkedList(int aa) {
		Node a = new Node(aa);
		head = a;
	}
	
	LinkedList() {
		Node head = null;
	}
	
	public void add(int bb) {
		Node b = new Node(bb);
		if(head == null) {
			head = b;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = b;
	}
	
	public void add(Node b) {
		if(head == null) {
			head = b;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = b;
	}
	
	public void printList() {
		if(head == null) {
			System.out.println(" Empty list");
		}
		Node temp = head;
		while(temp != null) {
			System.out.print(" "+ temp.val);
			temp = temp.next;
		}
	}

	public void reverseList() {
		if(head == null || head.next == null) {
			System.out.println(" Empty list");
			return;
		}
		
		Node h = head;
		Node tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}
		Node temp = null;
		Node next_tail = null;
		while(h != null) {
			temp = h;
			h = h.next;
			temp.next = next_tail;
			next_tail = temp;
		}
		head = next_tail;
		printList();
	}
	
	public void reverse_k(int num) {
		Node curr = head; Node next = null; Node prev = null;
		int k = 1;
		while(curr != null && k<3) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			k++;
			if(k == 3) {
				Node temp = prev;
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = curr;
				k = 1;
			}
		}
		head = prev;
	}
	
	public void removeLoop() {
		Node fast = head; Node slow = head;
		while(fast != null && slow != null && fast.next != null) {
			slow= slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				slow.next = null;
				return;
			}
		}
		return;
	}
	
	public void rotate_k(int k) {
		Node temp;
		Node curr = head; int count = 0;
		Node tail = head;
		while(tail.next != null) {
			tail = tail.next;
		}
		while (curr != null && count < k) {
			temp = curr;
			curr = curr.next;
			temp.next = null;
			tail.next = temp;
			tail = tail.next;
			count ++;
			System.out.println(" "+curr.val + " " + temp.val + " " + tail.val + " " + count);
		}
		head = curr;
	}
}
