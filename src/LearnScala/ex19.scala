package LearnScala

/**
  * Created by lyk on 2019-9-3.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class ex19 {
  class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) = { current = x }
  }
}
