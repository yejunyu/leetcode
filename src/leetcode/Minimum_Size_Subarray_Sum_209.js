/**
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function (target, nums) {
    let result = Infinity
    let i = 0
    let subLength = 0
    let sum = 0
    for (let j = 0; j < nums.length; j++) {
        sum += nums[j]
        while (sum >= target) {
            subLength = j - i + 1
            result = result > subLength ? subLength : result
            sum -= nums[i++]
        }
    }
    return result === Infinity ? 0 : result
};
let target = 4, nums = [1, 4, 4]
console.log(minSubArrayLen(target, nums))
