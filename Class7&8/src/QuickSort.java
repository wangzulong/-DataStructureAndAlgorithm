import java.util.Arrays;

/**
 * @Author: wangzulong
 * @Date: 2020/12/4 10:57
 */
public class QuickSort {

	public static void qSort(int[] data, int left, int right) {
		int base = data[left]; // 就是我们的基准数，取序列的第一个
		int leftIndex = left; // 表示从左边开始找的位置
		int rightIndex = right; // 表示从右边开始找的位置
		while (leftIndex < rightIndex) {
			while (leftIndex < rightIndex && data[rightIndex] >= base) {
				rightIndex--;
			}
			if (leftIndex < rightIndex) {
				int temp = data[rightIndex];
				data[rightIndex] = data[leftIndex];
				data[leftIndex] = temp;
				leftIndex++;
			}

			while (leftIndex < rightIndex && data[leftIndex] <= base) {
				leftIndex++;
			}
			if (leftIndex < rightIndex) {
				int temp = data[rightIndex];
				data[rightIndex] = data[leftIndex];
				data[leftIndex] = temp;
				rightIndex--;
			}
		}

		if (left < leftIndex)
			qSort(data, left, leftIndex - 1);
		if (rightIndex < right)
			qSort(data, rightIndex + 1, right);
	}

	public static void main(String[] args) {
		int[] a = { 4, 6, 8, 1 };
		qSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		Arrays.sort(a);
	}
}
