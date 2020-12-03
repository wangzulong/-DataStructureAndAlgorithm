/**
 * @Author: wangzulong
 * @Date: 2020/11/27 9:01
 */
public class RoundList {
	public static void main(String[] args) {
		RoundList roundList = new RoundList();
		System.out.println(roundList.lastRemaining(5, 2));
	}

	public int lastRemaining(int n, int m) {
		ListNode startNode = new ListNode(0);
		ListNode currentNode = startNode;
		for (int i = 1; i < n; i++) {
			currentNode.next = new ListNode(i);
			currentNode = currentNode.next;
		}
		currentNode.next = startNode;
		currentNode = startNode;

		if (m == 1) {
			return n - 1;
		}

		while (currentNode.next != currentNode) {
			for (int i = 1; i < m - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
			currentNode = currentNode.next;
		}
		return currentNode.value;
	}

	public class ListNode {
		int value;
		ListNode next;

		public ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}
}
