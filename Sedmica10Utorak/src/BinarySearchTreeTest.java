import javax.swing.text.AbstractDocument.Content;

public class BinarySearchTreeTest {
	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(3);
		tree.add(6);
		tree.add(4);

		tree.print();
		if (tree.contains(9))
			System.out.println("Postoji!");
		else
			System.out.println("Ne postoji");
	}
}
