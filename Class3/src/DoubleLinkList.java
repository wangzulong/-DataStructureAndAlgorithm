/**
 * @Author: wangzulong
 * @Date: 2020/11/25 9:21
 */
public class DoubleLinkList { // 双向链表
	private DoubleNode head;
	private DoubleNode tail;

	DoubleLinkList() {
		head = null;
		tail = null;
	}

	public void insertHead(int data) {
		DoubleNode newNode = new DoubleNode(data);
		if (head == null) {
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
	}

	public void deleteHead() {
		if (head == null)
			return;
		if (head.next == null) {
			tail = null;
		} else {
			head.next.prev = null;
		}
		head = head.next;
	}

	public void deleteKey(int data) {
		DoubleNode currentNode = head;
		while (currentNode.value != data) {
			if (currentNode.next == null) {
				System.out.println("没有该值节点");
				return;
			}
			currentNode = currentNode.next;
		}

		if (currentNode == head) {
			deleteHead();
		} else {
			currentNode.prev.next = currentNode.next;
			if (currentNode == tail) {
				tail = currentNode.prev;
				currentNode.prev = null;
			} else {
				currentNode.next.prev = currentNode.prev;
			}
		}
	}
}

class DoubleNode {
	int value;
	DoubleNode prev;
	DoubleNode next;

	DoubleNode(int value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}
