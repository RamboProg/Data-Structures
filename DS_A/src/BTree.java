
import Lab.QueueObj;
import Lecture.Queue;

class Node {

	public Comparable data;
	public Node left, right;

	public Node(Comparable data) {
		this(data, null, null);
	}

	public Node(Comparable data, Node left, Node right) {

		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class BTree {
	private Node root;

	public BTree() {
		root = null;
	}

	public void add(Comparable key) {
		Node current = root, parent = null;
		while (current != null) {
			if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}

			else {
				parent = current;
				current = current.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
		if (root == null)
			return false;
		Node current = root;
		Node parent = root;
		boolean right = true;
		// searching for the node to be deleted
		while (key.compareTo(current.data) != 0) {
			if (key.compareTo(current.data) < 0) {
				right = false;
				parent = current;
				current = current.left;
			} else {
				right = true;
				parent = current;
				current = current.right;
			}
			if (current == null)
				return false;
		}

		Node substitute = null;
		// case 1: Node to be deleted has no children
		if (current.left == null && current.right == null)
			substitute = null;

		// case 2: Node to be deleted has one child
		else if (current.left == null)
			substitute = current.right;
		else if (current.right == null)
			substitute = current.left;
		else // case 3: Node to be deleted has two children
		{
			Node successor = current.right;
			Node successorParent = current;
			// searching for the inorder successor of the node to be deleted
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			substitute = successor;
			if (successorParent == current) {
				if (successor.right == null)
					successorParent.right = null;
				else
					successorParent.right = successor.right;
			} else {
				if (successor.right == null)
					successorParent.left = null;
				else
					successorParent.left = successor.right;
			}
			successor.right = current.right;
			successor.left = current.left;
			substitute = successor;
		} // case 3 done
		if (current == root) // Replacing the deleted node
			root = substitute;
		else if (right)
			parent.right = substitute;
		else
			parent.left = substitute;
		return true;

	}

	public void displayTree() {
		java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while (isRowEmpty == false) {
			java.util.Stack<Node> localStack = new java.util.Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	}

	public void zigzag(int n) {
		zigzag(root, n);
	}

	public void zigzag(Node curr, int n) {
		if (curr == null)
			return;
		else
			System.out.println(" " + curr.data);

		if (n == 0) {
			n = 1;
			zigzag(curr.left, n);
		} else if (n == 1) {
			n = 0;
			zigzag(curr.right, n);
		}

	}

	public static void main(String[] args) {
		BTree t = new BTree();
		t.add(9);
		t.add(5);
		t.add(4);
		t.add(3);
		t.add(8);
		t.add(6);
		t.add(14);
		t.add(12);
		t.add(16);

		t.zigzag(t.root, 1);

	}
}