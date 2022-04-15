package practise.lesson1dot3;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/13
 */
public class LinkedStack<T> implements Iterable<T> {
    private int size;
    private int cap;
    private Node head;

    private class Node {
        private T item;
        private Node next;
    }

    public LinkedStack(int cap) {
        this.cap = cap;
    }

    public void push(T item) throws Exception {
        if (isFull()) {
            throw new Exception("满了啊");
        }
        size++;
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("空了, 不能 pop 了");
        }
        T r = head.item;
        head = head.next;
        size--;
        return r;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) throws Exception {
        int a = 'a';
        int z = 'z';
        int n = 10;
        LinkedStack<String> s = new LinkedStack<>(n);
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int i1 = a + r.nextInt(z - a + 1);
            char c = (char) i1;
            System.out.println(c);
            s.push(String.valueOf(c));
        }
        System.out.println("==================");
//        for (LinkedStack.Node x = s.head; x != null; x = x.next) {
//            System.out.println(x.item);
//        }
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    @Override
    public Iterator<T> iterator() {
//        return null;
        return new ReverseArrayIterator(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private LinkedStack stack;

        public ReverseArrayIterator(LinkedStack stack) {
            this.stack = stack;
        }

        @Override
        public boolean hasNext() {
            return stack.head!=null;
        }

        @Override
        public T next() {
            try {
                return (T) stack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
