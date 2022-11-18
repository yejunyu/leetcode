package practise.link;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/10/30
 * https://leetcode.cn/problems/reverse-linked-list/
 **/
public class _206_反转链表 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static MyLink.Node reverseList1(MyLink.Node head) {
        if (head == null||head.next==null) {
            return head;
        }
        MyLink.Node newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static MyLink.Node reverseList2(MyLink.Node head) {
        if (head == null||head.next==null) {
            return head;
        }
        MyLink.Node newHead = null;
        while (head!=null){
            MyLink.Node tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        MyLink  link = new MyLink("a");
        link = link.init();
        MyLink.Node node = reverseList1(link.head);

    }
}
