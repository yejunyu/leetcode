package main

import (
	"fmt"
	"math"
)

// Shape /**
type Shape interface {
	Area() float64
	Perimeter() float64
}
type Rectangle struct {
	x, y int
}
type Circle struct {
	r int
}

func (r *Rectangle) Area() float64 {
	return float64(r.x * r.y)
}

func (r *Rectangle) Perimeter() float64 {
	return float64(2 * (r.x + r.y))
}

func (c *Circle) Area() float64 {
	return math.Pow(float64(c.r), 2) * math.Pi
}

func (c *Circle) Perimeter() float64 {
	return math.Pi * 2 * float64(c.r)
}

func printShapeInfo(s Shape) {
	fmt.Printf("面积为: %f 周长为: %f\n", s.Area(), s.Perimeter())
}

type Person struct {
	Name string
	Age  int
}
type Employee struct {
	EmployeeID int
	Person
}

func (e Employee) PrintInfo() {
	fmt.Printf("员工id:%d,姓名:%s,年龄:%d\n", e.EmployeeID, e.Name, e.Age)
}

/*
*
题目 ：定义一个 Shape 接口，包含 Area() 和 Perimeter() 两个方法。然后创建 Rectangle 和 Circle 结构体，实现 Shape 接口。在主函数中，创建这两个结构体的实例，并调用它们的 Area() 和 Perimeter() 方法。
考察点 ：接口的定义与实现、面向对象编程风格。
题目 ：使用组合的方式创建一个 Person 结构体，包含 Name 和 Age 字段，再创建一个 Employee 结构体，组合 Person 结构体并添加 EmployeeID 字段。为 Employee 结构体实现一个 PrintInfo() 方法，输出员工的信息。
考察点 ：组合的使用、方法接收者。
*/
func main() {
	var r = Rectangle{20, 1}
	fmt.Println(r.Area(), r.Perimeter())
	var c = Circle{r: 2}
	fmt.Println(c.Area(), c.Perimeter())
	printShapeInfo(&r) // 传递指针
	printShapeInfo(&c) // 传递指针
	var p = Person{Name: "yejunyu", Age: 18}
	var e = Employee{EmployeeID: 1, Person: p}
	e.PrintInfo()
}
