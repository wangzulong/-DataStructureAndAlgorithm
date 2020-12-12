import java.util.Map;

/**
 * @Author: wangzulong
 * @Date: 2020/12/4 15:44
 */
public class CardDp {
	public static void main(String[] args) {
		int weigth[] = { 1, 2, 3, 4, 5, 9 }; // 购物车那个问题 只需要一个价值就行了，重量都都没有。

		int w = 8;
		int n = 6;

		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weigth[i - 1] <= j) {
					dp[i][j] = Math.max(weigth[i - 1] + dp[i - 1][j - weigth[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][w]);
	}
}
