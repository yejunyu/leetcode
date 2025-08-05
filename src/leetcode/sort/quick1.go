package main

import (
	"fmt"
	"math/rand"
	"time"
)

// sort 是程序的入口函数
func sort(nums []int) {
	// 初始化随机数种子，这对于随机化 pivot 很重要
	rand.Seed(time.Now().UnixNano())

	// 调用 Hoare 风格的快速排序
	quickSortHoare(nums, 0, len(nums)-1)
}

// quickSortHoare 是使用 Hoare 分区方案的递归函数
func quickSortHoare(nums []int, l int, r int) {
	// 递归的基准条件：当子数组只有一个或没有元素时，它已经有序
	if l >= r {
		return
	}

	// 1. 调用 Hoare 分区函数，得到分界点 p
	//    注意：p 不是 pivot 的最终位置！
	//    它只是一个索引，保证 nums[l...p] 的所有元素都 <= pivotVal
	//    并且 nums[p+1...r] 的所有元素都 >= pivotVal
	p := partitionHoare(nums, l, r)

	// 2. 递归地对两个子数组进行排序
	//    !! 关键点 !!
	//    左边的子数组是 [l, p]，包含了分界点 p
	//    右边的子数组是 [p+1, r]
	quickSortHoare(nums, l, p)
	quickSortHoare(nums, p+1, r)
}

// partitionHoare 是 Hoare 分区方案的核心实现
func partitionHoare(nums []int, l int, r int) int {
	// --- Pivot 选择 ---
	// 经典的 Hoare 方案选择第一个元素作为 pivot。
	// 为了避免最坏情况（如在有序数组上），更好的方法是随机选择一个 pivot，
	// 然后将其与第一个元素交换，这样后续逻辑保持不变。
	pivotVal := nums[l]

	// --- 双指针初始化 ---
	// i 从左边界外侧开始，准备向右移动
	// j 从右边界外侧开始，准备向左移动
	i := l
	j := r

	// --- 主循环 ---
	// 这个循环会一直运行，直到 i 和 j 指针相遇或交错
	for {
		// 1. 移动左指针 i
		//    i 向右移动，直到找到一个 "不应该" 在左边的元素，
		//    即 nums[i] >= pivotVal
		for {
			i++
			if nums[i] >= pivotVal {
				break
			}
		}

		// 2. 移动右指针 j
		//    j 向左移动，直到找到一个 "不应该" 在右边的元素，
		//    即 nums[j] <= pivotVal
		for {
			j--
			if nums[j] <= pivotVal {
				break
			}
		}

		// 3. 检查指针是否交错
		//    如果 i >= j，说明分区过程已经完成。
		//    所有小于等于 pivotVal 的元素都在 j 的左边（或 j 的位置），
		//    所有大于等于 pivotVal 的元素都在 j 的右边。
		if i >= j {
			return j // 返回分界点 j
		}

		// 4. 交换
		//    如果指针还未交错，说明 i 找到了一个 "大" 数，j 找到了一个 "小" 数。
		//    交换它们，将它们放到正确的区域。
		nums[i], nums[j] = nums[j], nums[i]
	}
}

// --- 测试 ---
func main() {
	var nums = []int{9, 8, 9, 71, 61, 13, 6, 8, 7, 5, 4, 3, 2, 1, 61}
	sort(nums)
	fmt.Println(nums)
}
