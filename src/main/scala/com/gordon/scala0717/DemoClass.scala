package com.gordon.scala0717

object DemoClass {
  def main(args: Array[String]) {
    val people = new People
    people.name = "若泽数据"
     // people.age = 20  val不能重新赋值
//    println(people.name + " : " + people.age  )
//     println(people.name + " : " + people.age + " : " + people.gender)
     people.printInfo()
  }
}
// 定义个类
class People{
  // 定义属性
  var name:String = _ // _表示的是占位符  字符串为null 类似java的构造器初始化
  //var name:String = ""
  val age = 10  // val age:Int = 10
  //var s =
//  val gender = "M"
  private[this] val gender = "M"  //私有只能在People使用

  def printInfo(): Unit ={
    println("gender: " + gender)
  }

  // 定义方法 :String 可以删除
  def eat() = {
    name + " eat ...."
  }


}
