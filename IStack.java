package SMART;


public interface IStack<T> {
    public boolean isEmpty();
    public int size();
    public T pop();
    public void push(T ele);
    public T peek();
}
