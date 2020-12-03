/**
 * @Author: wangzulong
 * @Date: 2020/11/27 10:02
 */
public interface MyStackInterface<T> {
	public MyStackInterface<T> push(T t);

	public T pop();

	public int size();

	public boolean isEmpty();
}
