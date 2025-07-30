/**
 * Example 1:
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
function removeElement(nums, val) {
  let k = 0; // Pointer for the position of the next valid element

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== val) {
      nums[k] = nums[i]; // Move the valid element to the front
      k++; // Increment the count of valid elements
    }
  }
  console.log(nums)
  return k; // Return the count of valid elements
}

let nums = [3, 2, 2, 3];
let val = 3;
console.log(removeElement(nums, val)); // Output: 2, nums = [2, 2, _, _]
