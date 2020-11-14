
public class AVL {
	class Node {
		int height ;
		int val ;
		Node left , right ;
		Node(int val) {
			this.height = 1 ;
			this.val = val ;
			left = right = null ;
		}
	}
	private Node AVLroot = null ;
	public Node rightRotate(Node root) {
		Node left = root.left ;
		root.left = left.right ;
		left.right = root ;
		root.height = Math.max(getHeight(root.left) , getHeight(root.right)) + 1 ;
		left.height = Math.max(getHeight(left.left) , getHeight(left.right)) + 1 ;
		return left ;
		
	}
	public Node leftRotate(Node root) {
		Node right = root.right ;
		root.right = right.left ;
		right.left = root ;
		root.height = Math.max(getHeight(root.left) , getHeight(root.right)) + 1 ;
		right.height = Math.max(getHeight(right.left) , getHeight(right.right)) + 1 ;
		return right ;
		
	}
	private int getHeight(Node root) {
		if (root == null) {
			return 0 ;
		}
		return root.height ;
	}
	public void insert(int key) {
		AVLroot = insert(AVLroot , key) ;
	}
	private Node insert(Node root , int key) {
		if (root == null) {
			return new Node(key) ;
		}
		if (root.val < key) {
			root.right = insert(root.right , key) ;
		} else if (root.val > key) {
			root.left = insert(root.left , key) ;
		} else {
			return root ;
		}
		root.height = Math.max(getHeight(root.left) , getHeight(root.right))+ 1;
		int diff = getHeight(root.left) - getHeight(root.right) ;
		
		if (diff > 1 && root.left.val > key) {
			/*
						3
					2
				1
			*/
			return rightRotate(root) ;
		} else if (diff < -1 && root.right.val < key) {
			/*
				3
					4
						5
			*/
			return leftRotate(root) ;
		} else if (diff > 1 && root.left.val < key) {
			/*			3
					1
						2
			*/
			root.left = rightRotate(root.left) ;
			return rightRotate(root) ;
		} else if (diff < -1 && root.right.val > key) {
			/*
					3
						5
					4
			*/
			root.right = rightRotate(root.right) ;
			return leftRotate(root) ;
		}
		return root ;
	}
	private Node delete(Node root , int key) {
		if (root == null) {
			return root ;
		}
		
	public void inOrder() {
		inOrder(AVLroot) ;
	}
	public void preOrder() {
		preOrder(AVLroot) ;
	}
	private void inOrder(Node root) {
		if (root == null) {
			return ;
		}
		inOrder(root.left) ;
		System.out.print(root.val + " ") ;
		inOrder(root.right) ;
	}
	private void preOrder(Node root) {
		if (root == null) {
			return ;
		}
		System.out.print(root.val + " ") ;
		preOrder(root.left) ;
		preOrder(root.right) ;
	}
}
class Test {
	public static void main(String args[]) {
		Scanner ip = new Scanner(System.in) ;
		AVL ob = new AVL() ;
		int t = ip.nextInt() ;
		int num ;
		for (int i = 0 ; i < t ; i++) {
			System.out.println("Enter 1.To insert 2.Find root 3.Height of the tree 4.Inorder 5.Preorder") ;
			int ch = ip.nextInt() ;
			switch(ch) {
				case 1 :num = ip.nextInt() ; 
						ob.insert(num) ;
						break ;
				case 4: ob.inOrder() ;
						break ;
				case 5 : ob.preOrder() ;
						break ;
			}
		}
	}
}