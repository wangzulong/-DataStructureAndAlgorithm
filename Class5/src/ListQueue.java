import java.util.List;

/**
 * @Author: wangzulong
 * @Date: 2020/12/1 15:04
 */
public class ListQueue {
	ListNode head;
	ListNode tail;
	int size;

	public void push(int m) {
		ListNode newNode = new ListNode(m);
		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public int pop() {
		if (size == 0) {
			return -1;
		}
		ListNode popNode = head;
		head = head.next;
		size--;
		return popNode.value;
	}
}

class ListNode {
	int value;
	ListNode next;

	public ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}
