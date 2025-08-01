package main

import (
	"fmt"
	"sync"
	"time"
)

func Filter(nums []int, condition func(n int) bool) []int {
	var result = []int{}
	for _, v := range nums {
		if condition(v) {
			result = append(result, v)
			fmt.Print(v, "\t")
		}
	}
	return result
}

/*
*
题目 ：编写一个程序，使用 go 关键字启动两个协程，一个协程打印从1到10的奇数，另一个协程打印从2到10的偶数。
考察点 ： go 关键字的使用、协程的并发执行。
题目 ：设计一个任务调度器，接收一组任务（可以用函数表示），并使用协程并发执行这些任务，同时统计每个任务的执行时间。
考察点 ：协程原理、并发任务调度。
*/
func fun1(isOdd bool) {
	var nums = []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	if isOdd {
		Filter(nums, func(n int) bool {
			return n%2 == 1
		})
	} else {
		Filter(nums, func(n int) bool {
			return n%2 == 0
		})
	}
}
func fun2(isOdd bool, wg *sync.WaitGroup) {
	defer wg.Done()
	start := 1
	if !isOdd {
		start = 2
	}
	for i := start; i <= 10; i += 2 {
		fmt.Print(i, "\t")
		time.Sleep(time.Second)
	}
}
func task1() { time.Sleep(1 * time.Second) }
func task2() { time.Sleep(2 * time.Second) }
func task3() { time.Sleep(500 * time.Millisecond) }

func taskSchedule(tasks ...func()) {
	var wg sync.WaitGroup
	wg.Add(len(tasks))
	for i, task := range tasks {
		go func(index int, task func()) {
			defer wg.Done()
			var start = time.Now()
			task()
			fmt.Printf("%d号任务执行了 %s 时间\n", i, time.Since(start))
		}(i, task)
	}
	wg.Wait()
}
func main() {
	//go fun1(true)
	//go fun1(false)
	//time.Sleep(10 * time.Second)
	//var wg sync.WaitGroup
	//wg.Add(2)
	//go fun2(true, &wg)
	//go fun2(false, &wg)
	//wg.Wait()
	var start = time.Now()
	taskSchedule(task1, task2, task3)
	fmt.Printf("总共执行了 %s 时间", time.Since(start))
}
