import java.util.Arrays;

/**
 * @Author: wangzulong
 * @Date: 2020/12/4 15:29
 */
public class Dp {
	public static void main(String[] args) {
		int[] value = { 60, 100, 120, 40 };
		int[] weight = { 10, 20, 40, 20 };

		int w = 60;
		int n = 4;

		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weight[i - 1] <= j) {
					dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][w]);
		int[] result = new int[n];
		int totalValue = dp[n][w];
		for (int i = n; i >= 1; i--) {
			if (dp[i][w] != dp[i - 1][w] && totalValue > 0) {
				result[i - 1] = 1;
				i--;
				totalValue = totalValue - dp[i][w];
			} else {
				result[i - 1] = 0;
			}
		}

		System.out.println(Arrays.toString(result));
	}
}
