
public class BinaryTreeExample {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insertInTree(6);
		tree.insertInTree(3);
		tree.insertInTree(9);
		tree.insertInTree(1);
		tree.insertInTree(15);
		tree.insertInTree(7);
		tree.insertInTree(14);

		System.out.println("In order: ");
		tree.displayInOrder();
		System.out.println("\nPre order: ");
		tree.displayPreOrder();
		System.out.println("\nPos order: ");
		tree.displayPosOrder();

		 System.out.println();
			System.out.println("\nThe height of tree is " + tree.height(tree.root));
	}

}
