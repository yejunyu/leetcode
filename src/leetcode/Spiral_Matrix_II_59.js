/**
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function (n) {
    let matrix = new Array(n).fill(0).map(() => new Array(n).fill(0));
    let top = 0, bottom = n - 1, left = 0, right = n - 1
    let num = 1
    while (left <= right && top <= bottom) {
        for (let i = left; i <= right; i++) {
            matrix[top][i] = num++
        }
        top++
        for (let i = top; i <= bottom; i++) {
            matrix[i][right] = num++
        }
        right--
        if (left <= right && top <= bottom) {
            for (let i = right; i >= left; i--) {
                matrix[bottom][i] = num++
            }
            bottom--
            for (let i = bottom; i >= top; i--) {
                matrix[i][left] = num++
            }
            left++
        }
    }
    return matrix
};

console.log(generateMatrix(6))