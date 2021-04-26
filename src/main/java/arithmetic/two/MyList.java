package arithmetic.two;

/**
 * 自定list接口
 * @param <E>
 */
public interface MyList<E> {
	public void add(E e);
	
	public void remove(int i);
	
	public void remove(Object e);
	
	public E get(int i);
	
	public int size();
	
	public boolean isEmpty();
	
}
