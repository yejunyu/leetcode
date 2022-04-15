package practise.lesson1dot3;

import java.util.Arrays;
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
public class ArrStack<T> implements Iterable<T> {
    private int size;
    private T[] items;
    private int cap;

    public ArrStack(int cap) {
        this.cap = cap;
        items = (T[]) new Object[cap];
    }

    public void push(T item) {
        if (isFull()) {
            resize(2 * size);
        }
        items[size++] = item;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("空了, 不能 pop 了");
        }
        T t = items[--size];
        items[size] = null;
        if (size > 0 && size <= cap / 4) {
            resize(cap / 2);
        }
        return t;
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

    public void resize(int max) {
        T[] newT = (T[]) new Object[max];
        for (int i = 0; i < size; i++) {
            newT[i] = items[i];
        }
        cap = max;
        items = newT;
        newT = null;
    }

    public static void main(String[] args) throws Exception {
        int a = 'a';
        int z = 'z';
        int n = 10;
        ArrStack<String> s = new ArrStack<>(n);
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int i1 = a + r.nextInt(z - a + 1);
            char c = (char) i1;
            System.out.println(c);
            s.push(String.valueOf(c));
        }
        s.push("aaaaa");
        System.out.println(Arrays.toString(Arrays.stream(s.items).toArray()));
        System.out.println(s.size());
        System.out.println(s.isEmpty());
//        for (int i = 0, size = s.size; i < size; i++) {
//            System.out.println(s.pop());
//        }
        System.out.println(Arrays.toString(Arrays.stream(s.items).toArray()));
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }
    }
}
