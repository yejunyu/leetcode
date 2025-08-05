package main

/*
*
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
*/
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	var result = map[*ListNode]bool{}
	var p1, p2 = headA, headB
	for p1 != nil && p1.Next != nil {
		result[p1] = true
		p1 = p1.Next
	}
	for p2 != nil && p2.Next != nil {
		if result[p2] {
			return p2
		}
		p2 = p2.Next
	}
	return nil
}
func main() {

}
