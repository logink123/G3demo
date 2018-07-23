package com.gordon.scala0717

object DemoAbstract {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.speak
  }
  // 抽象类的定义abstract
  abstract class Animal {
    // 属性或者方法只有定义没有实现
    var name:String
    var age: Int
    def speak
  }
  class Dog extends Animal {
    var age: Int = 1

    def speak: Unit = {
      println("巨人，死哪去了，爷饿了....")
    }
    var name: String = "小巨人"
  }


}
