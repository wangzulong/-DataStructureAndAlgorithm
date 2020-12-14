/**
 * @Author: wangzulong
 * @Date: 2020/12/12 10:39
 */
public class BitMap {
	int[] size;
	int maxValue;

	public BitMap(int maxValue) {
		this.maxValue = maxValue;
		size = new int[maxValue >> 8 + 1];
	}

	public static void main(String[] args) {
		BitMap bitMap = new BitMap(64);
		bitMap.add(2);
		bitMap.add(3);
		bitMap.add(7);

		System.out.println(bitMap.contains(4));
		System.out.println(bitMap.contains(7));

		bitMap.remove(7);
		System.out.println(bitMap.contains(7));
	}

	public void add(int n) {
		int index = n >> 8;
		int location = n & 31;
		size[index] |= 1 << location;
	}

	public boolean contains(int n) {
		int index = n >> 8;
		int location = n & 31;
		int flag = size[index] & 1 << location;
		if (flag == 0) {
			return false;
		}
		return true;
	}

	public void remove(int n) {
		int index = n >> 8;
		int location = n & 31;
		size[index] &= 0 << location;
	}
}
