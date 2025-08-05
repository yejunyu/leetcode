package main

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	var s, f = head, head
	for i := 0; i < n; i++ {
		if f.Next == nil {
			return nil
		}
		f = f.Next
	}
	for f != nil && f.Next != nil {
		s = s.Next
		f = f.Next
	}
	s.Next = s.Next.Next
	return head
}
func main() {

}
