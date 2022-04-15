package practise.lesson1dot3;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/13
 */
public class Queue<T> implements Iterable<T> {

    private int size;
    private Node first;
    private Node last;

    private class Node {
        private T data;
        private Node next;
    }

    public Queue() {
    }

    public void enqueue(T t) {
        Node node = new Node();
        node.data = t;
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    public T dequeue() throws Exception {
        if (isEmpty()) {
            last = null;
            throw new Exception("空的,不能 dequeue");
        }
        T t = first.data;
        first = first.next;
        size--;
        return t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        int a = 'a';
        int z = 'z';
        int n = 10;
        Queue<String> s = new Queue<>();
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int i1 = a + r.nextInt(z - a + 1);
            char c = (char) i1;
            System.out.println(c);
            s.enqueue(String.valueOf(c));
        }
        System.out.println("==================");
        for (int i = 0, size = s.size(); i < size; i++) {
            String dequeue = s.dequeue();
            System.out.println(dequeue);
        }
    }
}
