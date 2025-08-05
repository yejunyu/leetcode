package main

func middleNode(head *ListNode) *ListNode {
	var s, f = head, head
	for f != nil && f.Next != nil {
		s = s.Next
		f = f.Next.Next
	}
	return s
}
func main() {

}
