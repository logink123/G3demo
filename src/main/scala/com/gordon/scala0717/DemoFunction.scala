package com.gordon.scala0717

object DemoFunction {
  def main(args: Array[String]){
    //函数定义add有返回值  因为scala有类型推到，所以int+int=int 返回类型可以去掉
    //def add(x:Int,y:Int){
    def add(x:Int,y:Int):Int={
        //x-y  //不管中间多少过程，只返回之后一行的值
        x+y
     }
    println(add(3,5))
    println("add******************************")
    //函数sayHello没有返回值
    def sayHello(): Unit = {
      println("sayHello Hello ruoze")
    }
     //    sayHello()
    sayHello //对于没有参数的方法可以去掉括号调用，有一种函数除外（）
    println("sayHello******************************")
    //条件表达式
   val x=1000
    //    if (x>0) {
    //      true}
    //      else{
    //      false
    //    }
    val a = if (x>0) true else false
    println(a)
    println("x******************************")
    //  循环to  until Range
    println(1 to 10 ) //Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(1 until 10 ) //Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
    //1.until(10) 1 until 10
    //1.to(10) = 1 to 10
    println(Range(1,10,3))  //第三个参数为步长，步长不能为0
    //循环的写法特殊
    for(i <- 0 until 10  if i%2==0) {
      println(i)
    }
    println("数据******************************")
   //数组TODO... 数组的时候详细讲解
    Array("若泽","老J","Spark","Hadoop").foreach(ele => println(ele))
  }
  //默认参数 命名参数  变长参数
  def loadSparkConf(fileName:String = "spark-default.conf"): Unit = {
    println(fileName)
  }
  println("参数******************************")
  loadSparkConf("spark-ruoze.conf")//覆盖
  loadSparkConf() //默认  括号必须带一下
  // 命名参数： 了解即可
  def teacher(spark:String,linux:String): Unit ={
    println(spark)
    println(linux)
  }
  //调用
      teacher("ruoze", "jepson")
      println("~~~~")
      teacher(linux="jepson", spark = "ruoze")
  // 变长参数：可变参数
  def sum1(a:Int,b:Int)={
     a+b
  }
  println(sum1(2,4))
  println("sum1******************************")
  def sum(nums:Int*) = {
    var result = 0
    for(num <- nums) { // 类似Java中的增强的for循环
      result += num
    }
    result //方法最后一行为返回值
  }
  println(sum1(2,4))
  println(sum(1.to(10) :_*)) //:_*就这么记
  println("sum******************************")
  def printTeachers(teachers:String*): Unit = {
    for(teacher <- teachers) {
      println(teacher)
    }
  }
  printTeachers("若泽","老J")
  printTeachers(Array("若泽","老J"):_*)//数组变成可变参数
  println("teacher******************************")
}
