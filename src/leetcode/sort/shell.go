package main

import "fmt"

func sort(nums []int) {
	var n = len(nums)
	for gap := n / 2; gap > 0; gap = gap / 2 {
		for i := gap; i < n; i++ {
			var key = nums[i]
			var j = i - gap
			for j >= 0 && key < nums[j] {
				nums[j+gap] = nums[j]
				j = j - gap
			}
			nums[j+gap] = key
		}
	}
}
func main() {
	var nums = []int{9, 8, 71, 61, 13, 6, 7, 5, 4, 3, 2, 1}
	sort(nums)
	fmt.Println(nums)
}
