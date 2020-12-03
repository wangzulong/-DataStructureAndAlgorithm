/**
 * @Author: wangzulong
 * @Date: 2020/11/25 8:57
 */
public class MyLinkedList {
	private ListNode head; // 头节点
	private int size = 0; // 大小

	public void insertHead(int data) { // 插入链表的头部
		ListNode newListNode = new ListNode(data);
		newListNode.next = head; // 栈内存引用
		head = newListNode;
		size++;
	}

	public void insertNth(int data, int position) { // 插入链表的中间未知，在n个未知插入
		if (position == 0) {
			insertHead(data);
		} else {
			ListNode currentNode = head;
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.next; // 一直往后遍历
			}
			ListNode newListNode = new ListNode(data);
			newListNode.next = currentNode.next; //
			currentNode.next = newListNode;
			size++;
		}
	}

	public void deleteHead() {
		head = head.next;
		size--;
	}

	public void deleteNth(int data, int position) {
		if (position == 0) {
			deleteHead();
		} else {
			ListNode currentNode = head;
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.next; // 一直往后遍历
			}
			currentNode.next = currentNode.next.next;
			size--;
		}
	}

	public void print() {
		ListNode currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	public void find(int data) {
		ListNode currentNode = head;
		while (currentNode != null) {
			if (currentNode.value == data) {
				break;
			}
			currentNode = currentNode.next;
		}
	}
}

class ListNode {
	int value; // 值
	ListNode next; // 下一个的指针

	ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}
