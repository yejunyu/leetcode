/**
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    // 说明不是大了就是小了
    if (target < nums[0] || target > nums[nums.length - 1]) {
        return -1
    }
    var left = 0
    var right = nums.length
    while (left <= right) {
        let mid = Math.floor((left + right) / 2)
        if (target === nums[mid]) {
            return mid
        } else if (target > nums[mid]) {
            left = mid + 1
        } else if (target < nums[mid]) {
            right = mid - 1
        }
    }
    return -1
};
nums = [-1, 0, 3, 5, 9, 12], target = 9
console.log(search(nums, target))


