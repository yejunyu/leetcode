package main

func partition(head *ListNode, x int) *ListNode {
	var dummy1 = &ListNode{}
	var dummy2 = &ListNode{}
	var p, q = dummy1, dummy2
	var c = head
	for c != nil {
		if c.Val < x {
			p.Next = c
			p = p.Next
		} else {
			q.Next = c
			q = q.Next
		}
		c = c.Next
	}
	q.Next = nil
	p.Next = dummy2.Next
	return dummy1.Next
}
func main() {

}
