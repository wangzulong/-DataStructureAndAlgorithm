/**
 * @Author: wangzulong
 * @Date: 2020/11/27 11:26
 */
public class KuoHaoStack {
	public static boolean isOK(String s) {
		MyStackInterface<Character> brackets = new ArrayStack<>(20);
		char charArray[] = s.toCharArray();

		for (char c : charArray) { // (O(n))
			switch (c) {
			case '{':
			case '(':
			case '[':
				brackets.push(c); // O(1)
				break;
			case '}':
				if (brackets.pop() == null) {
					return false;
				}
				if (brackets.pop().equals("{")) {
					break;
				} else {
					return false;
				}
			case ')':
				if (brackets.pop() == null) {
					return false;
				}
				if (brackets.pop() == '(') {
					break;
				} else {
					return false;
				}
			case ']':
				if (brackets.pop() == null) {
					return false;
				}
				if (brackets.pop() == '[') {
					break;
				} else {
					return false;
				}
			default:
				break;
			}
		}
		return brackets.isEmpty();
	}
}
