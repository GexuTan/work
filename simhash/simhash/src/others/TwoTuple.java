package others;
/**
 * <p>
 * Title: TwoTuple
 * </p>
 * <p>
 * Description: 两个元素的元组，用于在一个方法里返回两种类型的值
 * </p>
 * 
 * @author Xewee.Zhiwei.Wang@gmail.com
 * @site http://wzwahl36.net
 * @version 2012-3-21 上午11:15:03
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B> {
	public final A first;
	public final B second;

	public TwoTuple(A a, B b) {
		this.first = a;
		this.second = b;
	}
}

