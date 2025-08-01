package main

import "fmt"

func sort(nums []int) {
	for i := 0; i < len(nums); i++ {
		var minIndex = i
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[minIndex] {
				minIndex = j
			}
		}
		nums[i], nums[minIndex] = nums[minIndex], nums[i]
	}
}

/*
*
稳定版
*/
func sort1(nums []int) {
	for i := 0; i < len(nums); i++ {
		var minIndex = i
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[minIndex] {
				minIndex = j
			}
		}
		var minVal = nums[minIndex]
		for k := minIndex; k > i; k-- {
			nums[k] = nums[k-1]
		}
		nums[i] = minVal
	}
}
func main() {
	var nums = []int{9, 8, 71, 61, 13, 6, 7, 5, 4, 3, 2, 1}
	sort1(nums)
	fmt.Println(nums)
}
