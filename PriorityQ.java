package SMART;

public class PriorityQ {
    public static void main(String[] args) {
        MyIntPriorityQueue q = new MyIntPriorityQueue();
        q.offer(13);
        q.offer(5);
        q.offer(1);
        q.offer(17);

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
