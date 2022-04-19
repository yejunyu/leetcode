package practise.lesson1dot3;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author : YeJunyu
 * @description : get LRU 实现
 * 1. 链表为空能否工作
 * 2. 链表只有一个节点能否工作
 * 3. 链表只有两个节点能否工作
 * 4. 处理头尾节点时是否能正常工作
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/15
 */
public class DLinkedList<T> implements Iterable<T> {

    private int size;
    private int cap;
    private Node head;
    private Node tail;

    private class Node {
        private T data;
        private Node pre;
        private Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) && Objects.equals(pre, node.pre) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, pre, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public DLinkedList(int cap) {
        this.cap = cap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return cap == size;
    }

    public Node offer(T data) {
        if (isFull()) {
            System.out.println("满了, 不能插了");
            return null;
        }
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
        }
        tail = newNode;
        size++;
        return newNode;
    }

    public T peek() {
        return tail.data;
    }

    private Node peek(int index, boolean reverse) {
        Node x = head;
        if (reverse) {
            x = tail;
        }
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                break;
            }
            if (reverse) {
                x = x.pre;
            } else {
                x = x.next;
            }
        }
        return x;
    }

    public Node peek(int index) {
        if (size == 0) {
            System.out.println("size 是 0");
            return null;
        }
        if (index > size || index <= 0) {
            System.out.println("index 有误");
            return null;
        }
        Node r;
        int n = size / 2;
        // 从后往前找
        if (index > n) {
            index = size + 1 - index;
            r = peek(index, true);
        } else {
            r = peek(index, false);
        }
        return r;
    }

    public Node get(T data) {
        DLinkedList.Node x = head;
        DLinkedList.Node r = null;
        for (int i = 0; i < size; i++) {
            if (x.data.equals(data)) {
                // x 前后连接起来
                if (i == 0) {
                    System.out.println("不用动");
                    return r;
                }
                x.pre.next = x.next;
                x.next.pre = x.pre;
                // x 放头
                x.next = head;
                head.pre = x;
                head = x;
                r = x;
                break;
            }
            x = x.next;
        }
        return r;
    }

    public void show() {
        while (head!=null){
            System.out.print(head);
            head = head.next;
        }
    }

    public boolean palindrome() {
        if (isEmpty()) {
            System.out.println("空的");
            return false;
        }
        if (size == 1) {
            return true;
        }
        Node n1 = head;
        Node n2 = tail;
        for (int i = 0; i < size / 2; i++) {
            if (n1.data != n2.data) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.pre;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public Node reverseList(Node head) {
        /* iterative solution */
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public Node reverseList1(Node head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private Node reverseListInt(Node head, Node newHead) {
        if (head == null) return newHead;
        Node next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public void reverse() {
        if (size <= 1) {
            System.out.println("无需翻转");
            return;
        }
        for (int i = size; i > 1; i--) {
            Node n1 = peek(i);
            Node n2 = peek(i - 1);
            n1.next = n2;
            n2.next = null;
        }
        Node x = tail;
        tail = head;
        head = x;
    }

    public void reverse1(Node p1, Node p2) {
        if (head.next == null) {
        }
    }

    public boolean isLoop() {
        if (head == null) {
            System.out.println("空链表");
            return false;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node x = head;
        while (x != null) {
            if (p1 == null || p2 == null) {
                return false;
            }
            if (p1 == p2) {
                return true;
            }
            x = x.next;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

    public void merge(DLinkedList l1) {

    }

    /**
     * 1. 单链表反转
     * 2. 链表中环检测
     * 3. 两个有序链表合并
     * 4. 删除链表中倒数第 n 个节点
     * 5. 求链表中间节点
     */
    public static void test1() {
        int n = 3;
        DLinkedList<Integer> a = new DLinkedList<>(n);
        for (int i = 1; i <= n; i++) {
            a.offer(i);
        }
        a.show();
        a.head = a.reverseList(a.head);
        a.show();
    }

    public static void test2() {
        int n = 3;
        DLinkedList<Integer> a = new DLinkedList<>(n);
        for (int i = 1; i <= n; i++) {
            a.offer(i);
        }
        a.show();
        System.out.println(a.isLoop());
        DLinkedList.Node n1 = a.peek(n - 1);
        System.out.println(n1);
        DLinkedList.Node n2 = a.peek(n);
        System.out.println(n2);
        n2.next = n1;
        System.out.println(n2.next);
        System.out.println(n1);
        System.out.println(a.isLoop());

    }


    public static void main(String[] args) {
//        int n = 10;
//        DLinkedList<Integer> a = new DLinkedList<>(n);
//        while (!a.isFull()) {
//            Random r = new Random();
//            int i1 = r.nextInt(n);
//            System.out.print(i1 + " ");
//            a.offer(i1);
//        }
//        a.offer(100);
//        System.out.println("==========");
//        // 遍历
//        a.show();
//        System.out.println(a.get(2));
//        a.show();
//        System.out.println(a.get(4));
//        a.show();
//        System.out.println(a.peek(3));
//        System.out.println(a.peek(9));
//        DLinkedList<String> b = new DLinkedList<>(6);
//        b.offer("a");
////        b.offer("b");
////        b.offer("c");
////        b.offer("c");
////        b.offer("b");
//        b.offer("a");
//        System.out.println(b.palindrome());
//        DLinkedList.test1();
        DLinkedList<Integer> a = new DLinkedList<>(3);
        DLinkedList.Node node1 = (DLinkedList.Node) a.offer(1);
        DLinkedList.Node node2 = (DLinkedList.Node) a.offer(2);
        DLinkedList.Node node3 = new DLinkedList(3).new Node();
        node3.data = 3;
        DLinkedList.Node p = node1.next;
        node1.next = node3;
        node3.next = node2;
        a.show();
    }
}
