package practise.link;

import java.util.Currency;

/**
 * @Author yjy
 * @Description 所有val值都在[1, 1000]之内。
 * 操作次数将在[1,1000]之内。
 * @Date 2023/4/27
 **/
public class MyLink {

    Node head;
    int size;

    static class Node {
        Integer val;
        Node next;

        public Node(Integer data) {
            this.val = data;
        }
    }

    public MyLink() {
        head = new Node(null);
    }

    int size() {
        return this.size;
    }

    Integer get1(int index) {
        int i = -1;
        if (index < 0) {
            return -1;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            i++;
            if (index == i) {
                return cur.val == null ? -1 : cur.val;
            }
        }
        return -1;
    }

    Integer get(int index) {
        Node cur = head.next;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur == null ? -1 : cur.val;
    }

    void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    void addAtTail(int val) {
        Node node = new Node(val);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    void addAtIndex(int index, int val) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index error");
        }
        Node cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("index error");
        }
        Node cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLink myLink = new MyLink();
        myLink.addAtHead(1);
        myLink.print();
        myLink.addAtTail(3);
        myLink.print();
        myLink.addAtIndex(1, 2);
        myLink.print();
        System.out.println(myLink.get(1));
        myLink.deleteAtIndex(1);
        System.out.println(myLink.get(1));
    }

    public void print() {
        System.out.println("size: " + this.size());
        Node cur = head;
        StringBuilder sb = new StringBuilder("head->");
        while (cur.next != null) {
            cur = cur.next;
            sb.append(cur.val + "->");
        }
        sb.append("null");
        System.out.println(sb);
    }

    public void init() {
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
    }
}
