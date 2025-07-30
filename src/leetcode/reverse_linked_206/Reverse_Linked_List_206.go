package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode
	var cur = head
	for cur != nil {
		var temp = cur.Next
		cur.Next = pre
		pre = cur
		cur = temp
	}
	return cur
}
func reverseList1(head *ListNode) *ListNode {
	return recursion(head, nil)
}
func recursion(cur *ListNode, pre *ListNode) *ListNode {
	if cur == nil {
		return pre
	}
	var temp = cur.Next
	cur.Next = pre
	pre = cur
	cur = temp
	return recursion(cur, pre)
}

func main() {

}
