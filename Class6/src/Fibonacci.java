/**
 * @Author: wangzulong
 * @Date: 2020/12/1 16:15
 */
public class Fibonacci { // 时间复杂度 O(2^n) 空间复杂度O(2^n)

	private static int data[]; // 初始换全部是0

	// f(n) = f(n-1) + f(n-2)
	public static int fab(int n) {
		if (n <= 2) {
			return 1; // 递归终止条件
		}
		return fab(n - 1) + fab(n - 2); // 递归条件
	}

	public static int fac(int n) { // 求N的阶乘 用普通递归怎么写 5=5*4*3*2*1=> f(n) =
		if (n <= 1)
			return 1;
		return n * fac(n - 1);
	}

	public static int noFab(int n) { // 不用递归 O(n)
		// 循环
		if (n <= 2)
			return 1;
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static int fab2(int n) { // 用数组来做缓存 将为了O(n)，空间也降至为O(n)
		if (n <= 2)
			return 1; // 递归的终止条件
		if (data[n] > 0) {
			return data[n];
		}
		int res = fab2(n - 1) + fab2(n - 2); // 继续递归的过程
		data[n] = res;
		return res;
	}

	public static int tailFac(int n, int res) { // 尾递归 传结果，res就是我们每次保存的结果
		System.out.println(n + ":" + res); // 这个地方打印出来的值是怎么样的？
		if (n <= 1)
			return res;
		return tailFac(n - 1, n * res); // 倒着算
	}

	public static int tailFab(int pre, int res, int n) {
		if (n <= 2) {
			return res;
		}
		return tailFab(res, pre + res, n - 1);
	}
}
