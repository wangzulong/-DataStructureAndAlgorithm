import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: wangzulong
 * @Date: 2020/12/14 9:59
 */

class Point {
	int x;
	int y;
}

public class BFS {
	// 地图的行
	int n;
	// 地图的列
	int m;
	// 安琪的位置x
	int dx;
	// 安琪的位置y
	int dy;
	// 邻接矩阵
	int data[][];
	// 标记数据 走过的位置
	boolean mark[][];

	public void bfs(int x, int y) {
		if ((x < 1 || x > n || y < 1 || y > m)) {
			return;
		}
		if (x == dx && y == dy) {
			System.out.println("true");
			return;
		}
		mark[x][y] = true;
		Queue<Point> queue = new ArrayBlockingQueue<>(n * m);
		Point start = new Point();
		start.x = x;
		start.y = y;
		queue.add(start);
		// ACM想到的
		int next[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (!queue.isEmpty()) {// O(n)
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = point.x + next[i][0];
				int nexty = point.y + next[i][1];
				if (nextx < 1 || nextx > n || nexty < 1 || nexty > m)
					continue;
				;
				if (data[nextx][nexty] == 0 && !mark[nextx][nexty]) {
					if (nextx == dx && nexty == dy) {
						System.out.println("true");
						return;
					}

					Point newPoint = new Point();
					newPoint.x = nextx;
					newPoint.y = nexty;
					mark[nextx][nexty] = true;
					queue.add(newPoint);
				}
			}
		}
	}
}
