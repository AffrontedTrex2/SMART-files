package SMART;

public class MyQueue<T> implements IQueue<T> {

    private Node<T> head;
    private Node<T> currentNode;
    private int size;
    
    public MyQueue() {
        this.head = null;
        this.currentNode = null;
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

    @Override
    public T pull() {
        if (this.size > 0)
        {
            this.size--;
            T temp = this.head.data;
            this.head = this.head.next;
            return temp;
        }
        return null;
    }

    @Override
    public void offer(T ele) {
        if (size == 0)
        {
            this.head = new Node(ele);
            this.currentNode = this.head;
        }
        else
        {
            this.currentNode.next = new Node(ele);
            this.currentNode = this.currentNode.next;
        }
        this.size++;
    }

    @Override
    public T peek() {
        if (this.size > 0)
        {
            return this.head.data;
        }
        return null;
    }
    
}
