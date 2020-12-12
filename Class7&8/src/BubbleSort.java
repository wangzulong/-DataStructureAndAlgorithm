/**
 * @Author: wangzulong
 * @Date: 2020/12/4 10:06
 */
public class BubbleSort {
	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag)
				break;
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

// a:2 b:3
// 3 2 => a:3 b:2
// 用加减
//a = a + b => a = 3+2 =5;
//b = a - b => b = 5-3 =2;
//a = a - b => a = 5-2 =3;
