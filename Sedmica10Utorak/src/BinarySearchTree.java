
public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(int value) {
		if (root == null)
			root = new Node(value);
		else
			add(root, value);

	}

	private void add(Node current, int value) {
		if (current == null) {
			current = new Node(value);
			return;
		}
		if (value <= current.value) {
			if (current.left == null) {
				System.out.println("Adding " + " value " + value + " at "
						+ current.value + " left");
				current.left = new Node(value);
				return;
			}
			add(current.left, value);
		} else {
			if (current.right == null) {
				System.out.println("Adding " + " value " + value + " at "
						+ current.value + " right");
				current.right = new Node(value);
				return;
			}
			add(current.right, value);
		}

	}

	public void print() {
		print(root);
	}

	public void print(Node root) {
		if (root == null)
			return;
		print(root.left);
		System.out.println(root.value);
		print(root.right);
	}

	public boolean contains(int value) {
		if (root.value == value)
			return true;
		return contains(root, value);
	}

	private boolean contains(Node current, int value) {
		if (current == null)
			return false;
		if (current.value == value)
			return true;
		else if (value <= current.value) {
			return contains(current.left, value);
		} else {
			return contains(current.right, value);
		}
	}

	public Node getRoot() {
		return root;
	}

	public class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

	}
}