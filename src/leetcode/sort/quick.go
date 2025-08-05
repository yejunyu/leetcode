package main

import "fmt"

func sort(nums []int) {
	var l, r = 0, len(nums) - 1
	quickSort(nums, l, r)
}

func quickSort(nums []int, l int, r int) {
	if l >= r {
		return
	}
	var pivot = partition(nums, l, r)
	quickSort(nums, l, pivot-1)
	quickSort(nums, pivot+1, r)
}

func partition(nums []int, l int, r int) int {
	var j = l
	var pivot = nums[r]
	for i := l; i < r; i++ {
		if nums[i] < pivot {
			nums[i], nums[j] = nums[j], nums[i]
			j++
		}
	}
	nums[j], nums[r] = nums[r], nums[j]
	fmt.Println(j)
	return j
}
func main() {
	var nums = []int{9, 8, 9, 71, 61, 13, 6, 8, 7, 5, 4, 3, 2, 1, 61}
	sort(nums)
	fmt.Println(nums)
}
