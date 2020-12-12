import java.util.BitSet;

/**
 * @Author: wangzulong
 * @Date: 2020/12/8 14:05
 */
public class BloomFilter {
	private int size;
	private BitSet bits;

	public BloomFilter(int size) {
		this.size = size;
		this.bits = new BitSet(size);
	}

	public static void main(String[] args) {
		// O(1000000000)
		// 8bit= 1byte
		BloomFilter bloomFilter = new BloomFilter(Integer.MAX_VALUE); // 21亿
		System.out.println(bloomFilter.hash_1("1"));
		System.out.println(bloomFilter.hash_2("1"));
		System.out.println(bloomFilter.hash_3("1"));

		bloomFilter.add("1111");
		bloomFilter.add("1123");
		bloomFilter.add("11323");

		System.out.println(bloomFilter.find("1"));
		System.out.println(bloomFilter.find("1123"));
	}

	public void add(String key) {
		int hash1 = hash_1(key);
		int hash2 = hash_2(key);
		int hash3 = hash_3(key);
		bits.set(hash1, true);
		bits.set(hash2, true);
		bits.set(hash3, true);
	}

	public boolean find(String key) {
		if (bits.get(hash_1(key)) && bits.get(hash_2(key)) && bits.get(hash_3(key))) {
			return true;
		}
		return false;
	}

	public int hash_1(String key) {
		int hash = 0;
		int i;
		for (i = 0; i < key.length(); ++i) {
			hash = 33 * hash + key.charAt(i);
		}
		return Math.abs(hash) % size;
	}

	public int hash_2(String key) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < key.length(); i++) {
			hash = (hash ^ key.charAt(i)) * p;
		}
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		return Math.abs(hash) % size;
	}

	public int hash_3(String key) {
		int hash, i;
		for (hash = 0, i = 0; i < key.length(); ++i) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);
		return Math.abs(hash) % size;
	}
}
