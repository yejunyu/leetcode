package main

import (
	"fmt"
	"sync"
	"sync/atomic"
)

// --- Mutex 版本 ---

type MutexCounter struct {
	mutex sync.Mutex
	count int64
}

func (c *MutexCounter) Add(val int64) {
	c.mutex.Lock()
	c.count += val
	c.mutex.Unlock()
}

func (c *MutexCounter) Get() int64 {
	c.mutex.Lock()
	defer c.mutex.Unlock()
	return c.count
}

func runMutexCounter() {
	var wg sync.WaitGroup
	var counter MutexCounter
	wg.Add(10)

	for i := 0; i < 10; i++ {
		go func() {
			defer wg.Done()
			for j := 0; j < 1000; j++ {
				counter.Add(1)
			}
		}()
	}
	wg.Wait()
	fmt.Println("Mutex Counter:", counter.Get())
}

// --- Atomic 版本 ---

type AtomicCounter struct {
	count int64
}

func (c *AtomicCounter) Add(val int64) {
	atomic.AddInt64(&c.count, val)
}

func (c *AtomicCounter) Get() int64 {
	return atomic.LoadInt64(&c.count)
}

func runAtomicCounter() {
	var wg sync.WaitGroup
	var counter AtomicCounter
	wg.Add(10)

	for i := 0; i < 10; i++ {
		go func() {
			defer wg.Done()
			for j := 0; j < 1000; j++ {
				counter.Add(1)
			}
		}()
	}
	wg.Wait()
	fmt.Println("Atomic Counter:", counter.Get())
}

func main() {
	runMutexCounter()
	runAtomicCounter()
}
