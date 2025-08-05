package main

func detectCycle(head *ListNode) *ListNode {
	var slow, fast = head, head
	var flag = false
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			// 相遇时让slow回到起点
			flag = true
			slow = head
			break
		}
	}
	if flag {
		for {
			if slow == fast {
				return slow
			}
			slow = slow.Next
			fast = fast.Next
		}
	}
	return nil
}
func main() {

}
