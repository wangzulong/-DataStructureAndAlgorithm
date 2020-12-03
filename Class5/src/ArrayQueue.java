/**
 * @Author: wangzulong
 * @Date: 2020/12/1 13:15
 */
public class ArrayQueue {
	private int data[]; // 存放数据
	private int head = 0; // 队头
	private int tail = 0; // 队尾
	private int n = 0;
	private int size = 0;

	public ArrayQueue(int cap) {
		data = new int[cap];
		n = cap;
	}

	public void push(int m) { // 入队列 O(1)
		// 判断队列是否已经满了
		if (tail == n) { // 在这里去移动 最好O(1)，最坏O(n).平均时间复杂度， 链表是不能使用CPU缓存
			moveArrayQueue();
			return;
		}
		data[tail++] = m;
		size++;
	}

	public void moveArrayQueue() {
		for (int i = 0; i < n; i++) {
			data[i] = data[head + i];
		}
		head = 0;
		tail = n;
	}

	public int pop() { // 出队列 O(1)
		// 要判断队列是否为空
		if (isEmpty()) {
			return -1;
		}
		int m = data[head];
		head++;
		size--;
		return m;
	}

	public boolean isEmpty() {
		if (head == tail) {
			return true;
		}
		return false;
	}
}
