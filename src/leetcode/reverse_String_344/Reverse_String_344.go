package main

import "fmt"

/*
*
Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/
func reverseString(s []byte) {
	var sLen = len(s)
	for i, j := 0, sLen-1; i < sLen/2; i, j = i+1, j-1 {
		var temp = s[i]
		s[i] = s[j]
		s[j] = temp
	}
}

/*
*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
*/
func reverseStr(s string, k int) string {
	var result = ""
	for i := 0; i < len(s); i += 2 * k {
		var b = []byte(s[i:min(i+k, len(s))])
		reverseString(b)
		result += string(b)
		result += s[min(i+k, len(s)):min(2*k, len(s))]
	}
	return result
}

func main() {
	var s = "123"
	fmt.Println(s[3:3])
}
