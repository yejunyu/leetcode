package main

func singleNumber(nums []int) int {
	var result = map[int]bool{}
	for _, num := range nums {
		if result[num] {
			delete(result, num)
		} else {
			result[num] = true
		}
	}
	for i, _ := range result {
		return i
	}
	return -1
}
func main() {

}
