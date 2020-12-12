/**
 * @Author: wangzulong
 * @Date: 2020/12/7 11:52
 */
public class BinarySearchTree {
	int data;
	BinarySearchTree left;
	BinarySearchTree right;

	public BinarySearchTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void insert(BinarySearchTree root, int data) {
		if (root == null) {
			return;
		}
		// 根节点小 我们要放到右边
		if (root.data < data) {
			if (root.right == null) {
				root.right = new BinarySearchTree(data);
			} else {
				insert(root.right, data);
			}
		} else {
			if (root.left == null) {
				root.left = new BinarySearchTree(data);
			} else {
				insert(root.left, data);
			}
		}
	}

	public void find(BinarySearchTree root, int data) {
		if (root != null) {
			if (root.data > data) {
				find(root.left, data);
			} else if (root.data < data) {
				find(root.right, data);
			} else {
				System.out.println("找到了" + data);
				return;
			}
		}
	}

	public void remove(BinarySearchTree root, int data) {

	}
}
