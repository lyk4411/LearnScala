package LearnScala

/**
  * Created by lyk on 2019-8-28.
  * Package name: LearnScala
  * Porject name: LearnScala
  */


class PackageStudy {
  private var a = 0
  private[this] var b = 1
  // 只能在类内部使用，对象都不能直接使用

  def getb(): Int = b
  def setb(bin:Int): Unit = {
    b = bin
  }

  var m = PackageStudy.c
  //  var n = PackageStudy.d // 在伴生类中直接访问伴生对象的 private[this] 变量，会报错。
  var o = PackageStudy.get_d()


}

object PackageStudy {

  private var c = 2
  private[this] var d = 3

  // 伴生对象的 private[this] 变量，也只能在对象内部使用，在伴生类中无法直接使用。
  def get_d(): Int = d


  def main(args: Array[String]): Unit = {
    val a_obj = new PackageStudy
    println(a_obj.a)
    //    println(a_obj.b) //直接访问 类中的 private[this] 的变量，会报错
    println(a_obj.getb())


    println(a_obj.m)
    println(a_obj.o)
    val an_obj = new PackageStudy
    println("an_obj", an_obj.getb())
    an_obj.setb(33)
    println("an_obj", an_obj.getb())
    println(a_obj.getb())

  }
}