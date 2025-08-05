package main

import "fmt"

func sort(nums []int) {
	mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, l int, r int) {
	if l >= r {
		return
	}
	var mid = l + (r-l)/2
	fmt.Println(mid)
	mergeSort(nums, l, mid)
	mergeSort(nums, mid+1, r)
	merge(nums, l, mid, r)
}

func merge(nums []int, l int, mid int, r int) {
	var temp = make([]int, r-l+1)
	var i, j, k = l, mid + 1, 0
	for i <= mid && j <= r {
		if nums[i] < nums[j] {
			temp[k] = nums[i]
			i++
		} else {
			temp[k] = nums[j]
			j++
		}
		k++
	}
	// 还有没排序完的
	for i <= mid {
		temp[k] = nums[i]
		i++
		k++
	}
	for j <= r {
		temp[k] = nums[j]
		j++
		k++
	}
	for _, v := range temp {
		nums[l] = v
		l++
	}
}
func main() {
	var nums = []int{9, 8, 9, 71, 61, 13, 6, 8, 7, 5, 4, 3, 2, 1, 61}
	sort(nums)
	fmt.Println(nums)
}
