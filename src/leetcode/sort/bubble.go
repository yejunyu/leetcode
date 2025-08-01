package main

import "fmt"

func sort(nums []int) {
	var sortedIndex = 0
	var n = len(nums)
	for sortedIndex < n {
		var isSwap = false
		for i := n - 1; i > sortedIndex; i-- {
			if nums[i] < nums[i-1] {
				nums[i], nums[i-1] = nums[i-1], nums[i]
				isSwap = true
			}
		}
		if !isSwap {
			break
		}
		sortedIndex++
	}
}
func main() {
	var nums = []int{9, 8, 71, 61, 13, 6, 7, 5, 4, 3, 2, 1}
	sort(nums)
	fmt.Println(nums)
}
