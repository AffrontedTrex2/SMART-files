package SMART;

import MyPrograms.Node;

public class LinkedListLab {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;

        System.out.println(isCyclic(head));
    }

    public static boolean isCyclic(Node head)
    {
        Node fast = head.next;
        Node slow = head;
        
        while (fast != null && fast.next != null)
        {
            if (fast.next == slow)
            {
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}
