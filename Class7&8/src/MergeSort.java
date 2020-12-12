import java.util.Arrays;

/**
 * @Author: wangzulong
 * @Date: 2020/12/3 13:53
 */
public class MergeSort {
	public static void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(data, left, mid);
			mergeSort(data, mid + 1, right);
			merge(data, left, mid, right);
		}
	}

	public static void merge(int[] data, int left, int mid, int right) {
		int[] temp = new int[data.length];
		int leftIndex = left;
		int rightIndex = mid + 1;
		int loc = left;
		while (leftIndex <= mid && rightIndex <= right) {
			if (data[leftIndex] < data[rightIndex]) {
				temp[loc] = data[leftIndex];
				leftIndex++;
				loc++;
			} else {
				temp[loc] = data[rightIndex];
				rightIndex++;
				loc++;
			}
		}

		while (leftIndex <= mid) {
			temp[loc++] = data[leftIndex++];
		}

		while (rightIndex <= right) {
			temp[loc++] = data[rightIndex++];
		}

		for (int i = left; i <= right; i++) {
			data[i] = temp[i];
		}

	}

	public static void main(String[] args) {
		int[] a = { 9, 5, 6, 8, 0, 3, 7, 1 };
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
