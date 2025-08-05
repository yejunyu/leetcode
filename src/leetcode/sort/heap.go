package main

import (
	"fmt"
)

func sort(nums []int) {
	// 1. 建堆
	buildHeap(nums)
	// 2. 排序
	heapSort(nums)
}

func heapSort(nums []int) {
	// 最大堆,堆顶是最大的
	var n = len(nums)
	// 取出堆顶元素和最后一位交换
	for i := n - 1; i > 0; i-- {
		nums[0], nums[i] = nums[i], nums[0]
		heapify(nums, 0, i)
	}
}
func heapify(nums []int, i, heapSize int) {
	// 比较左右两个子节点把最大的放上面
	var largest = i
	var left = i*2 + 1
	var right = i*2 + 2
	if left < heapSize && nums[left] > nums[largest] {
		largest = left
	}
	if right < heapSize && nums[right] > nums[largest] {
		largest = right
	}
	// 需要调整
	if largest != i {
		nums[i], nums[largest] = nums[largest], nums[i]
		// 换了之后节点变了还得递归的往上调整
		heapify(nums, largest, heapSize)
	}
}
func buildHeap(nums []int) {
	// 小于n/2的都是有叶子的节点
	var n = len(nums)
	for i := n/2 - 1; i >= 0; i-- {
		heapify(nums, i, n)
	}
}
func main() {
	var nums = []int{9, 8, 71, 61, 13, 6, 7, 5, 4, 3, 2, 1}
	sort(nums)
	fmt.Println(nums)
}
