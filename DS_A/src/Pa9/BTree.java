package Pa9;

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

	// ----------------------------------------------------------------------------//

	// Question 9-3
	public Comparable maxKey() {
		int max = 0;
		Node current = this.root;
		while (current.right != null) {
			if ((int) current.data > max)
				max = (int) current.data;
			current = current.right;
		}
		return max;
	}

	// Question 9-4
	public int findMax() {
		return findMax(root);
	}

	public static int findMax(Node n) {
		if (n == null)
			return -1;
		int maxLeft = findMax(n.left);
		int maxRight = findMax(n.right);
		return Math.max(((Integer) n.data), Math.max(maxLeft, maxRight));

	}

	// Question 9-5
	public int size() {
		return size(root);
	}

	public int size(Node curr) {
		if (curr == null)
			return 0;
		return 1 + size(curr.left) + size(curr.right);
	}

	public int numLeaves() {
		return numLeaves(root);
	}

	public int numLeaves(Node curr) {
		if (curr == null)
			return 0;
		if (curr.left == null && curr.right == null)
			return 1;
		return numLeaves(curr.left) + numLeaves(curr.right);
	}

	public int sum() {
		return sum(root);
	}

	public int sum(Node curr) {
		if (curr == null)
			return 0;
		else {
			int total = ((Integer) curr.data);
			total += sum(curr.left);
			total += sum(curr.right);
			return total;
		}

	}

	public boolean isBST() {
		return isBST(root);
	}

	public boolean isBST(Node curr) {
		if (curr == null)
			return true;
		if (curr.left != null && ((Integer) maxValue(curr.left)).compareTo((Integer) (curr.data)) > 0)
			return false;
		if (curr.right != null && ((Integer) minValue(curr.right)).compareTo((Integer) (curr.data)) <= 0)
			return false;

		return isBST(curr.left) && isBST(curr.right);
	}

	public Comparable minValue(Node node) {
		Node current = node;
		while (current.left != null)
			current = current.left;
		return (current.data);
	}

	public Comparable maxValue(Node node) {
		Node current = node;
		while (current.right != null)
			current = current.right;
		return (current.data);
	}

	public int numLeftChildNodes() {
		return numLeftChildNodes(root);
	}

	public int numLeftChildNodes(Node n) {
		if (n == null)
			return 0;
		if (n.left != null && n.right == null)
			return 1 + numLeftChildNodes(n.left);
		return numLeftChildNodes(n.left) + numLeftChildNodes(n.right);
	}

	public int countOccur(Comparable key) {
		return occurRec(key, root);
	}

	public static int occurRec(Comparable key, Node curr) {
		if (curr == null)
			return 0;
		if (key.compareTo(curr.data) == 0)
			return 1 + occurRec(key, curr.left) + occurRec(key, curr.right);
		else
			return occurRec(key, curr.left) + occurRec(key, curr.right);
	}

	public boolean hasDups(Comparable key) {
		if (occurRec(key, root) <= 1)
			return false;
		return true;
	}

	public void mirror() {
		mirror(root);
	}

	public static void mirror(Node curr) {
		if (curr != null) {
			mirror(curr.left);
			mirror(curr.right);
			Node temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
		}
	}

	public String oddNodes() {
		return oddNodes(root);
	}

	public String oddNodes(Node n) {
		if (n == null)
			return "";
		return (((Integer) n.data).intValue() % 2 != 0 ? (n.data + " ") : "") + oddNodes(n.left) + oddNodes(n.right);
	}

	public void breadthTraversal() {
		QueueObj q = new QueueObj(1000);
		Node curr = root;
		if (curr != null)
			q.enqueue(curr);

		while (!q.isEmpty()) {
			Node temp = (Node) q.dequeue();
			if (temp.right != null)
				q.enqueue(temp.right);
			if (temp.left != null)
				q.enqueue(temp.left);

			System.out.println(temp.data + " ");
		}
	}

	public void printLevel(int lvl) {
		printLevel(lvl);
	}

	public void printLevel(Node n, int level) {
		if (n == null)
			return;
		if (level == 0) {
			System.out.print(n.data + " ");
		} else {
			printLevel(n.left, level - 1);
			printLevel(n.right, level - 1);
		}

	}

	public static void main(String[] args) {
		BTree t = new BTree();
		t.add(150);
		t.add(95);
		t.add(92);
		t.add(111);
		t.add(175);
		t.add(166);
		t.add(200);

		t.printLevel(1);

	}

}