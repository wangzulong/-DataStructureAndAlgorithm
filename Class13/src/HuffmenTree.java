import java.util.*;

/**
 * @Author: wangzulong
 * @Date: 2020/12/16 8:37
 */
public class HuffmenTree {
	HfmNode root;
	List<HfmNode> leafs; // 叶子节点
	Map<Character, Integer> weights; // 叶子节点的权重

	public HuffmenTree(Map<Character, Integer> weights) {
		this.weights = weights;
		leafs = new ArrayList<>();
	}

	public static void main(String[] args) {
		// a:3 b:24 c:6 d:20 e:34 f:4 g:12
		Map<Character, Integer> weights = new HashMap<Character, Integer>();
		// 一般来说：动态的加密，最开始是不知道里面有什么内容的。我们需要一个密码本，往往就是某个字典。如果是英文就用英文字典，统计次数。
		// 换密码本
		// 静态的文件。针对性的做编码.图像加密,没有特性的。hash加密（MD5）
		weights.put('a', 3);
		weights.put('b', 24);
		weights.put('c', 6);
		weights.put('d', 1);
		weights.put('e', 34);
		weights.put('f', 4);
		weights.put('g', 12);

		HuffmenTree huffmenTree = new HuffmenTree(weights);
		huffmenTree.createTree();
		Map<Character, String> code = huffmenTree.code();
		String str = "aceg";
		System.out.println("编码后的：" + huffmenTree.encode(str, code));
		System.out.println("解码后的：" + huffmenTree.decode(huffmenTree.encode(str, code), code));
	}

	public Map<Character, String> code() {
		Map<Character, String> map = new HashMap<>();
		for (HfmNode node : leafs) {
			String code = "";
			Character c = new Character(node.chars.charAt(0));// 叶子节点只有一个字符
			HfmNode current = node; // 只有一个点
			do {
				if (current.parent != null && current == current.parent.left) {
					code = "0" + code;
				}
				if (current.parent != null && current == current.parent.right) {
					code = "1" + code;
				}
				current = current.parent;
			} while (current.parent != null);
			map.put(c, code);
			System.out.println(c + ":" + code);
		}
		return map;
	}

	public String decode(String str, Map<Character, String> code) { // 解码 不会给你们写的，留给课后作业
		StringBuilder result = new StringBuilder();
		while (str.length() > 0) {
			for (Map.Entry<Character, String> entry : code.entrySet()) {
				if (str.startsWith(entry.getValue())) {
					result.append(entry.getKey());
					str = str.substring(entry.getValue().length());
				}
			}
		}
		return result.toString();
	}

	public String encode(String str, Map<Character, String> code) { // 解码 不会给你们写的，留给课后作业
		char[] charArray = str.toCharArray();
		StringBuilder result = new StringBuilder();
		for (char c : charArray) {
			result.append(code.get(c));
		}
		return result.toString();
	}

	// 叶子节点进行编码
	public void createTree() {
		Character[] keys = weights.keySet().toArray(new Character[0]);
		PriorityQueue<HfmNode> priorityQueue = new PriorityQueue<>();
		for (Character c : keys) {
			HfmNode hfmNode = new HfmNode();
			hfmNode.chars = c.toString();
			hfmNode.fre = weights.get(c);
			priorityQueue.add(hfmNode);
			leafs.add(hfmNode);
		}

		int len = priorityQueue.size();
		for (int i = 1; i <= len - 1; i++) {
			HfmNode node1 = priorityQueue.poll();
			HfmNode node2 = priorityQueue.poll(); // 每次取优先队列的前两个，最小的
			HfmNode newNode = new HfmNode();
			newNode.chars = node1.chars + node2.chars;
			newNode.fre = node1.fre + node2.fre;

			// 构建树的结构
			newNode.left = node1;
			newNode.right = node2;
			node1.parent = newNode;
			node2.parent = newNode;

			priorityQueue.add(newNode);
		}
		root = priorityQueue.poll(); // 最后这个点就是根节点
		System.out.println("最优二叉树(哈夫曼树)构建完成");
	}

}
