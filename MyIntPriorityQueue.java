package SMART;

public class MyIntPriorityQueue {
    private int size;
    private final int INIT_CAPACITY = 5;
    private int[] arr;

    public MyIntPriorityQueue() {
            this.size = 0;
            this.arr = new int[INIT_CAPACITY];
    }

    private void resize() {
            int[] temp = new int[this.size * 2];
            for (int i = 0; i < arr.length; i++) {
                    temp[i] = arr[i];
            }
            arr = temp;
    }

    public int poll() {
        int head = arr[0];
        arr[0] = arr[size - 1];
        this.size--;
        int location = 0;
        while (true) {
            int left = location * 2 + 1;
            int right = location * 2 + 2;

            if (left > this.size || right > this.size)
                break;
            
            int smaller = smallest(this.arr, location, left, right);

            if (location != smaller) {
                int temp = this.arr[location];
                this.arr[location] = this.arr[smaller];
                this.arr[smaller] = temp;
                location = smaller;
            } else
                break;
        }

        return head;
    }

    private int smallest(int arr[], int one, int two, int three) {
        if (arr[one] <= arr[two] && arr[one] <= arr[three])
            return one;
        if (arr[two] <= arr[one] && arr[two] <= arr[three])
            return two;
        return three;
    }

    public void offer(int data) {
        if (this.size + 1 > this.arr.length) {
                resize();
        }
        this.arr[this.size] = data;
        this.size++;
        int i = this.size - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (this.arr[i] < this.arr[parent]) {
                    int temp = arr[parent];
                    arr[parent] = arr[i];
                    arr[i] = temp;
            }
            i = parent;
        }
    }
    
    public int peek() {
        return arr[0];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
