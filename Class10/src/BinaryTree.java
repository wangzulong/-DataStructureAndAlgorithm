import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wangzulong
 * @Date: 2020/12/7 7:57
 */

class TreeNode {
	private char data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(char data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode D = new TreeNode('D', null, null);
		TreeNode H = new TreeNode('H', null, null);
		TreeNode K = new TreeNode('K', null, null);
		TreeNode C = new TreeNode('C', D, null);
		TreeNode G = new TreeNode('G', H, K);
		TreeNode B = new TreeNode('B', null, C);
		TreeNode F = new TreeNode('F', G, null);
		TreeNode E = new TreeNode('E', null, F);
		TreeNode A = new TreeNode('A', B, E);

		BinaryTree binaryTree = new BinaryTree();
		System.out.println("前");
		binaryTree.pre(A);
		System.out.println();
		System.out.println("中");
		binaryTree.in(A);
		System.out.println();
		System.out.println("后");
		binaryTree.post(A);
		System.out.println();
		System.out.println("层次遍历");
		binaryTree.levelOrder(A);
	}

	public void print(TreeNode node) {
		System.out.print(node.getData());
	}

	public void pre(TreeNode root) { // 前序遍历 根(输出) 左 右 时间复杂度？O(n) N^2 O(2*n)=>O(n);
		print(root);
		if (root.getLeft() != null) {
			pre(root.getLeft());
		}
		if (root.getRight() != null) {
			pre(root.getRight());
		}
	}

	public void in(TreeNode root) {
		if (root.getLeft() != null) {
			in(root.getLeft());
		}
		print(root);
		if (root.getRight() != null) {
			in(root.getRight());
		}
	}

	public void post(TreeNode root) {
		if (root.getLeft() != null) {
			post(root.getLeft());
		}
		if (root.getRight() != null) {
			post(root.getRight());
		}
		print(root);
	}

	public void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			print(temp);
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}
	}
}
