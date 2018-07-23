package com.gordon.scala0717

import scalikejdbc._
import scalikejdbc.config._
object Demo1 {

  def main(args: Array[String]): Unit = {
    // DBs.setup/DBs.setupAll loads specified JDBC driver classes.
    DBs.setupAll()
    // DBs.setup()
    // DBs.setup('legacy)
    // // Unlike DBs.setupAll(), DBs.setup() doesn't load configurations under global settings automatically
    // DBs.loadGlobalSettings()

    // loaded from "db.default.*"
    // loaded from "db.default.*"
//    val memberIds = DB readOnly { implicit session =>
//      sql"select id from members".map(_.long(1)).list.apply()
//    }
//    // loaded from "db.legacy.*"
//    val legacyMemberIds = NamedDB('legacy) readOnly { implicit session =>
//      sql"select id from members".map(_.long(1)).list.apply()
//    }
    // wipes out ConnectionPool
    // DBs.closeAll()
//    Class.forName("com.mysql.jdbc.Driver")
//    ConnectionPool.singleton("jdbc:mysql://localhost:3306/test", "root", "root")
    //    implicit val session = AutoSession
    case class User(id: Int, name: String, age: Int)
    //查询所有的数据
    val allColumns = (rs: WrappedResultSet) => User(
      id = rs int "id",
      name = rs.string("name"),
      age = rs.int("age"))
    //查询所有的用户
    val users: List[User] = DB readOnly { implicit session =>
      SQL("select * from user ").map(allColumns).list.apply()
    }
    //查询打印
    for (user <- users) {
      println(user.id + ":" + user.name + ":" + user.age)
    }

///  val names = DB readOnly { implicit session =>
//      sql"select name from emp".map { rs => rs.string("name") }.list.apply()
//    }
//
//    implicit val session = DB.readOnlySession
//    try {
//      val names = sql"select name from emp".map { rs => rs.string("name") }.list.apply()
//      // do something
//    } finally {
//      session.close()
//    }
//
    println("****************************************")
//     val name = "zhangguod"
     val id1=12
    //查询单条所有的用户
    val users1: List[User] = DB readOnly { implicit session =>
      SQL("select * from user where id = ${id1} ").map(allColumns).list.apply()
    }
    //查询打印
    for (user <- users1) {
      println(user.id + ":" + user.name + ":" + user.age)
    }

    //插入数据
    DB.autoCommit { implicit session =>
      SQL("insert into user(name,age) values(?,?)").bind("lisi", 99).update().apply()
    }
    //修改数据
    DB autoCommit { implicit session =>
     SQL("update user set age = ? where id = ?").bind(100, 10).update().apply()
//      sql"update emp set name = ${name} where id = ${id}".update.apply()
    }
    //删除数据
    def delete() = {
      DB.autoCommit { implicit session =>
        SQL("delete from user where id = ?").bind("100").update().apply()
      }


    //select查询到数据之后会产生一个rs的对象集，然后可以得到这个对象集里面的数据。
    def select() = {
      DB.readOnly { implicit session =>
        //val sql = SQL("select * from  ").map(rs => (rs.string("name"), rs.int("age"))).toList().apply()
        SQL("select * from  user ").map(rs => User(rs.int("id"), rs.string("name"), rs.int("age"))).list().apply()
      }
    }
      //批量插入
//          DB.autoCommit { implicit session =>
//            SQL("insert into people(name,age,fv) values(?,?,?)").bind("lisi", 20, 99).update().apply()
//          }
//          println(insertBatch)
      //    //在数据插入的时候建立一个事务。
      //    def insertBatch() = {
      //
      //      DB.localTx { implicit session =>
      //        SQL("insert into people(name,age,fv) values(?,?,?)").bind("王五", 26, 101).update().apply()
      //        val r = 1 / 0
      //        SQL("insert into people(name,age) values(?,?)").bind("刘璐", 30).update().apply()
      //      }



    }
  }

}
