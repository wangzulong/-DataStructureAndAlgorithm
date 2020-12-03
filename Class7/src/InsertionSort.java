import java.util.Arrays;

/**
 * @Author: wangzulong
 * @Date: 2020/12/3 11:28
 */
public class InsertionSort {
	public static int[] sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int data = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (data < a[j]) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = data;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 4, 6, 8, 1 };
		a = sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
