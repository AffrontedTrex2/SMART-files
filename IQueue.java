package SMART;


public interface IQueue<T> {
	public boolean isEmpty();
	public int size();
	public T pull();
	public void offer(T ele);
	public T peek();
}
