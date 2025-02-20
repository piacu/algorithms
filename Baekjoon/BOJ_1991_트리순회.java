import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	static class Node {
		char data;
		Node left;
		Node right;
		
		Node(char data) {
			this.data = data;
		}
	}
	
	static class Tree {
		public Node root;
		
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				root.left = leftData != '.' ? new Node(leftData) : null;
				root.right = rightData != '.' ? new Node(rightData) : null;
			} else {
				searchNode(root, data, leftData, rightData);
			}
		}
		
		public void searchNode(Node node, char data, char leftData, char rightData) {
	        if(node == null) {
	            return;
	        }else if(node.data == data) {
	            node.left = leftData != '.' ? new Node(leftData) : null;
	            node.right = rightData != '.' ? new Node(rightData) : null;
	        }else {
	            searchNode(node.left, data, leftData, rightData);  // 오른쪽 재귀 탐색
	            searchNode(node.right, data, leftData, rightData);  // 왼쪽 재귀 탐색
	        }
	    }
		
		public void preOrder(Node node) {
			System.out.print(node.data);
			if(node.left != null) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
		}
		
		public void inOrder(Node node) {
			if(node.left != null) inOrder(node.left);
			System.out.print(node.data);
			if(node.right != null) inOrder(node.right);
		}
		
		public void postOrder(Node node) {
			if(node.left != null) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			System.out.print(node.data);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			t.createNode(root, left, right);
		}
		
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
	

	}
}
