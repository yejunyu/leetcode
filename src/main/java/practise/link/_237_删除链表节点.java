package practise.link;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/10/30
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 **/
public class _237_删除链表节点 {

    /**
     * 删除链表节点
     *
     * @param link
     * @param node 4-》5-》1-》9
     *             4-》5-》9
     */
    public static void deleteNode(MyLink link, String node) {
        System.out.println("删除前");
        link.each();
        MyLink.Node p = link.head.next;
        while (p.next != null) {
            // 遍历
            if (p.data.equals(node)){
                if (p.next.next!=null){
                    p.data = p.next.data;
                    p.next = p.next.next;
                }else {
                    p.data=null;
                }

            }
            p = p.next;
        }
        System.out.println("删除后");
        link.each();

    }

    public static void main(String[] args) {
        MyLink  link = new MyLink("a");
        link = link.init();
        deleteNode(link,"c");
    }
}
