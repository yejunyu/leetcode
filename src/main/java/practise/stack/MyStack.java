package practise.stack;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/10/19
 **/
public class MyStack {
    private String[] items;
    private int count = 0;
    private int head, tail;

    public MyStack(int capacity) {
        this.items = new String[capacity];
        this.count = capacity;
    }

    public boolean enqueue(String item) {
        // 假如队列满了
        if ((tail + 1) % count == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % count;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % count;
        return ret;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.enqueue("a");
        myStack.enqueue("b");
        myStack.enqueue("c");
        for (int i = 0; i < 4; i++) {
            System.out.println(myStack.dequeue());
        }
        myStack.enqueue("a");
        System.out.println(myStack.dequeue());
    }
}
