package com.gordon.scala0717

object DemoConstruct {
  def main(args: Array[String]) {
    //主构造器
//    val girl = new Girl("森碟",18)
//    println(girl.name + " : " + girl.age + " : " + girl.city)//
   //附属构造器
//    val girl = new Girl("森碟",18, "13000000000", "深圳市南山区海印长城")
//    println(girl.name + " : " + girl.age + " : " + girl.phone + " : " + girl.address)
    val cindy = new Cindy("小森碟",10, "Computer")
    println(cindy.name + " : " + cindy.major)
    println(cindy)


  }
}
//构造函数中的参数以及类中的属性(非private的)都直接能够当做对象的属性来使用的
// 主构造函数
class Girl(val name:String, val age:Int)  {
  println("girl enter")

  def hate(): Unit = {
    println(name + " hate zidong")
  }
  var phone = ""
  // 附属构造函数: 第一行必须调用主构造器或者其他的附属构造器
  def this(name:String, age:Int, phone:String) {
    this(name, age)
    this.phone = phone
  }
  var address = ""
  def this(name:String, age:Int, phone:String, address:String) {
    this(name, age, phone)
    this.address = address
  }

  var city = "渔村" //(非private的)

  println("girl leave")
}
/**
  * 继承的时候，当我们创建子对象的时候，其实会先调用父类的构造方法
  * 专业需要用val
  */
class Cindy(name:String, age:Int, val major:String) extends Girl(name,age) {
  println("Cindy enter")
  def eat() = "吃饭"

  // 需要overwrite修饰符，如果你想重写父类中已有的方法时，一定需要添加overwrite修饰符
 override def toString = "cidy toString"

// override var city = "深圳"

  println("Cindy leave")
}