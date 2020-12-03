/**
 * @Author: wangzulong
 * @Date: 2020/11/27 10:04
 */
public class ArrayStack<T> implements MyStackInterface<T> {
	private T[] array = (T[]) new Object[1];
	private int n = 0;

	public ArrayStack(int cap) {
		array = (T[]) new Object[cap];
	}

	@Override
	public MyStackInterface<T> push(T t) { // O(1)
		judgeSize();
		array[n++] = t;
		return null;
	}

	private void judgeSize() {
		if (n >= array.length) {
			resize(2 * array.length);
		} else if (n > 0 && n <= array.length / 2) {
			resize(array.length / 2);
		}
	}

	private void resize(int size) { // O(n)
		T[] tempArray = (T[]) new Object[size];
		for (int i = 0; i < n; i++) {
			tempArray[i] = array[i];
		}
		array = tempArray;
	}

	@Override
	public T pop() { // O(1)
		if (isEmpty()) {
			return null;
		}
		T t = array[--n];
		array[n] = null;
		return t;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}
}
