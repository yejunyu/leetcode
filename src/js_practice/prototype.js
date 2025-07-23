function Dog(name) {
  this.name = name;
}

Dog.prototype.bark = function () {
  console.log(this.name + " says woof!");
};

const dog1 = new Dog("Buddy");
const dog2 = new Dog("Max");

console.log(dog1.name); // Buddy
console.log(dog2.name); // Max

dog1.bark(); // Buddy says woof!

console.log(dog1.bark === dog2.bark); // true, both dogs share the same bark method
console.log(dog1.__proto__ === Dog.prototype); // true, dog1's prototype is Dog.prototype
console.log(dog1.hasOwnProperty("bark")); // false, bark is not an own property of dog1
console.log(Dog.prototype.hasOwnProperty("bark")); // true, bark is an own property of Dog.prototype
