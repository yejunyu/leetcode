/**
 * Example 1:

 Input: nums = [-4,-1,0,3,10]
 Output: [0,1,9,16,100]
 Explanation: After squaring, the array becomes [16,1,0,9,100].
 After sorting, it becomes [0,1,9,16,100].
 Example 2:

 Input: nums = [-7,-3,2,3,11]
 Output: [4,9,9,49,121]
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {
    let left = 0;
    let right = nums.length - 1;
    let index = nums.length - 1
    const result = new Array(nums.length);
    while (left <= right) {
        const leftSquare = Math.pow(nums[left], 2);
        const rightSquare = Math.pow(nums[right], 2);
        if (leftSquare <= rightSquare) {
            result[index--] = rightSquare
            right--
        } else {
            result[index--] = leftSquare
            left++
        }
    }
    return result
}

let nums =[-7,-3,2,3,11]
console.log(sortedSquares(nums))
