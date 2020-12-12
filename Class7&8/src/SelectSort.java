/**
 * @Author: wangzulong
 * @Date: 2020/12/4 9:56
 */
public class SelectSort {
	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int minLoc = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minLoc]) {
					minLoc = j;
				}
			}
			int temp = a[minLoc];
			a[minLoc] = a[i];
			a[i] = temp;
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
