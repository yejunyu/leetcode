package practise.link;

import java.util.LinkedList;
import java.util.List;

public class MyLink {

    public final Node head;

    public MyLink(String data) {
        this.head = new Node();
        this.head.next = new Node(data);
    }


    public static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node(){}
    }

    public MyLink init() {
        Node node1 = new Node("b");
        Node node2 = new Node("c");
        Node node3 = new Node("d");
        this.head.next.next = node1;
        node1.next = node2;
        node2.next = node3;
        return this;
    }

    public void each() {
        Node p = this.head.next;
        while (p.next != null) {
            System.out.print(p.data+"->");
            p=p.next;
        }
    }

    public static void main(String[] args) {
        MyLink link = new MyLink("a");
        link = link.init();
        link.each();
    }
}
