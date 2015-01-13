
public class QueuePriority {

	private Node head;
	private Node tail;

	public QueuePriority() {
		this.head = null;
		this.tail = null;
	}

	public void push(int value, int priority) {

		Node newNode = new Node(value, priority);
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}

		if (head.priority < newNode.priority) {
			newNode.next = head;
			head = newNode;
			return;
		}

		Node previous = head;
		Node current = head.next;
		while (current != null) {
			if (current.priority < newNode.priority) {
				previous.next = newNode;
				newNode.next = current;
				return;
			}
			previous.next = current;
			current = current.next;

		}

		tail.next = newNode;
		tail = tail.next;

	}

	public int pop() {
		if (head == null) {
			throw new NullPointerException("Queue is empty!");
		}
		Node current = head;
		head = head.next;
		int value = current.value;
		current = null;
		return value;
	}

	public int peek() {
		if (head == null) {
			throw new NullPointerException("Queue is empty");
		}
		return head.value;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int getSize() {
		if (head == null)
			return 0;
		return getSize(head, 0);
	}

	private int getSize(Node current, int counter) {
		if (current == null)
			return counter;
		return getSize(current.next, counter + 1);
	}

	public boolean contains(int value) {
		if (head.value == value)
			return true;
		return contains(head, value);

	}

	private boolean contains(Node current, int value) {
		if (current == null)
			return false;
		if (current.value == value)
			return true;

		return contains(current.next, value);
	}

	public void print() {
		String str = "";
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();

	}

	class Node {
		public int value;
		public Node next;
		int priority;

		public Node(int value, int priority) {
			this.value = value;
			this.priority = priority;

		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

	}
}
