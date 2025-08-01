package main

import (
	"fmt"
	"time"
)

func one2ten() {
	var c = make(chan int)
	go func() {
		for i := 1; i <= 10; i++ {
			c <- i
			time.Sleep(time.Second)
		}
		close(c)
	}()
	go func() {
		for v := range c {
			fmt.Println(v)
		}
	}()
}

func one2hundred() {
	// 创建一个带缓冲的通道，缓冲区大小为100
	c := make(chan int, 100)

	// 启动生产者协程
	go func() {
		for i := 1; i <= 100; i++ {
			c <- i
		}
		close(c)
	}()

	// 启动消费者协程
	go func() {
		for v := range c {
			fmt.Println(v)
		}
	}()
}

/*
*
题目 ：编写一个程序，使用通道实现两个协程之间的通信。一个协程生成从1到10的整数，并将这些整数发送到通道中，另一个协程从通道中接收这些整数并打印出来。
考察点 ：通道的基本使用、协程间通信。
题目 ：实现一个带有缓冲的通道，生产者协程向通道中发送100个整数，消费者协程从通道中接收这些整数并打印。
考察点 ：通道的缓冲机制。
*/
func main() {
	one2ten()
	one2hundred()
	time.Sleep(20 * time.Second)
}
