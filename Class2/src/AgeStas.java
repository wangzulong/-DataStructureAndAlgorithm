import java.io.*;

/**
 * @Author: wangzulong
 * @Date: 2020/11/18 10:30
 */

/**
 * 1.数组的定义
 * 所谓数组，是有序的元素序列。 若将有限个类型相同的变量的集合命名，那么这个名称为数组名。组成数组的各个变量称为数组的分量，也称为数组的元素，有时也称为下标变量。用于区分数组的各个元素的数字编号称为下标。数组是在程序设计中，为了处理方便，
 * 把具有相同类型的若干元素按无序的形式组织起来的一种形式。这些无序排列的同类数据元素的集合称为数组。int 的数组你就不能存float 也不能存double
 * 数组是用于储存多个相同类型数据的集合。通常用Array表示，也称之为线性表，画图演示 2.特点 (1)数组是相同数据类型的元素的集合。
 * (2)数组中的各元素的存储是有先后顺序的，它们在内存中按照这个先后顺序连续存放在一起。内存地址
 * (3)数组元素用整个数组的名字和它自己在数组中的顺序位置来表示。例如，a[0]表示名字为a的数组中的第一个元素，a[1]代表数组a的第二个元素，以此类推。
 */
public class AgeStas {
	public static void main(String[] args) {
		String str = "";
		String fileName = "";

		long startTime = System.currentTimeMillis();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			int total = 0; // 21亿
			int data[] = new int[200];
			while ((str = br.readLine()) != null) { // 一行一行的读O(n)
				int age = Integer.valueOf(str);
				data[age]++;
				total++;
			}

			// O(n) 14亿, 100万/秒 * 1000 = 10亿 100~ 1000秒之间， 500秒以下
			System.out.println("总共数据大小:" + total);
			for (int i = 0; i < data.length; i++) {
				System.out.println(i + ":" + data[i]);
			}

			System.out.println("计算花费时间为:" + (System.currentTimeMillis() - startTime) + "ms");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
