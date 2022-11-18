package practise.link;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/11/18
 * https://leetcode.cn/problems/linked-list-cycle/
 * 判断链表是否有环
 **/
public class _141_环形链表 {

    public boolean hasCycle(MyLink.Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        MyLink.Node slow = head;
        MyLink.Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
