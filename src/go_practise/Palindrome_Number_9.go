package main

import "strconv"

/*
*
Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	var xStr = strconv.Itoa(x)
	for i, j := 0, len(xStr)-1; i < len(xStr)/2; i, j = i+1, j-1 {
		if xStr[i] != xStr[j] {
			return false
		}
	}
	return true
}
func main() {

}
