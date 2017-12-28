package SMART;

public class MyStack<T> implements IStack<T>{

    private Node<T> head;
    private int size;

    public MyStack() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    //O(1)
    @Override
    public T pop() {
        if (this.size > 0)
        {
            this.size--;
            T temp = this.head.data;
            this.head = this.head.next;
            return temp;
        }
        return null;
    }

    //O(1)
    @Override
    public void push(T ele) {
        if (size == 0)
        {
            this.head = new Node(ele);
        }
        else
        {
            Node newNode = new Node(ele);
            newNode.next = this.head;
            this.head = newNode;
        }

        this.size++;
    }

    //O(1)
    @Override
    public T peek() {
        if (this.size > 0)
        {
            return this.head.data;
        }
        return null;
    }
	
}
