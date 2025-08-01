package main

import "fmt"

func sort(nums []int) {
	for i := 1; i < len(nums); i++ {
		var key = nums[i]
		var j = i - 1
		for j >= 0 && key < nums[j] {
			nums[j+1] = nums[j]
			j--
		}
		nums[j+1] = key
	}
}
func main() {
	var nums = []int{9, 8, 71, 61, 13, 6, 7, 5, 4, 3, 2, 1}
	sort(nums)
	fmt.Println(nums)
}
