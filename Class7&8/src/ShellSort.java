/**
 * @Author: wangzulong
 * @Date: 2020/12/4 9:47
 */
public class ShellSort {
	public static int[] sort(int[] a) {
		for (int gap = a.length / 2; gap >= 1; gap = gap / 2) {
			for (int i = gap; i < a.length; i++) {
				int data = a[i];
				int j = i - gap;
				for (; j >= 0; j = j - gap) {
					if (data < a[j]) {
						a[j + gap] = a[j];
					} else {
						break;
					}
				}
				a[j + gap] = data;
			}
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
