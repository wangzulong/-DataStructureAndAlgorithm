/**
 * @Author: wangzulong
 * @Date: 2020/11/18 9:08
 */
public class BigO {
    public static void main(String[] args) {
        int a = 1; // 1次 O(1)
        for(int i = 0; i < 3; i++) { //这里会运行4次 在第4次的时候结束 i =3(0, 1, 2, 3)
            a = a + 1;               //这里运行3次  O(1), O(1) 1表示是常数，所有能确定的数字我们都用O（1），O(1000)=>o(1)
        }

        int n = Integer.MAX_VALUE;  // 表示n是未知

        int i = 1;

        for(int j = 0; j < n; j++) {
            while (i <= n) {
                i = i * 2;         // O(nlogn)
            }
        }

        while(i <= n) {
            i = i * 3; // O(logn)
        }
        // 2 ^ x = n => 求出x就是运行的次数 => x= log2(n) => 计算机忽略常数 => log n => O(logn)
        // 二分查找 O(logn)

        for (i = 0; i < n; i++) {
            a = a + 1;             //O(n)  n一定是未知的，如果n是已知的就是O(1)
        }

        for (i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a = a + 1;             //O(n^2)
            }
        }

        for (i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                a = a + 1;             //O(n^2);=> (n^2 + n) /2 => 又加减法的时候，找次数最高的那个
            }
        }
        /**
         *   我们怎么找时间复杂度：
         *   1.找到有循环的地方，
         *   2.找有网络请求（RPC，远程调用，分布式，数据库请求）的地方。
         */
        
    }
}
