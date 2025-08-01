package main

import "fmt"

/*
*
题目 ：编写一个Go程序，定义一个函数，该函数接收一个整数指针作为参数，在函数内部将该指针指向的值增加10，然后在主函数中调用该函数并输出修改后的值。
考察点 ：指针的使用、值传递与引用传递的区别。
题目 ：实现一个函数，接收一个整数切片的指针，将切片中的每个元素乘以2。
考察点 ：指针运算、切片操作。
*/
func fun1(p *int) {
	*p = *p + 10
}
func fun2(arr []int) {
	for i, v := range arr {
		arr[i] = v * 2
	}
}
func main() {
	var p = 100
	fun1(&p)
	fmt.Println(p)
	var arr = []int{1, 2, 3, 4, 5}
	fun2(arr)
	fmt.Println(arr)
}
