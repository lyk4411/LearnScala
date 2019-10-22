package Leetcode

/**
  * Created by lyk on 2019-10-22.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class NumberofIslands {
    val directions = List((0,1), (0,-1), (1,0), (-1,0))
    def numIslands(grid: Array[Array[Char]]): Int = {
      if (grid.isEmpty || grid(0).isEmpty) return 0
      val (width, height) = (grid(0).length, grid.length)
      var islands = 0
      def dfs(x:Int, y:Int):Unit = (x,y) match {
        case (x, _) if (x < 0 || x >= width) =>
        case (_, y) if (y < 0 || y >= height) =>
        case (x, y) if (grid(y)(x) == '1') => {
          grid(y)(x) = '0'
          directions.foreach ( d=> dfs(x+d._1, y+d._2))
        }
        case _ =>
      }
      (0 to width-1).foreach(x => (0 to height-1).foreach(y => {
        if (grid(y)(x) == '1') {
          islands += 1
          dfs(x, y)
        }
      }))
      islands
    }
}
object NumberofIslands {
  def main(args: Array[String]) {
    val a = new NumberofIslands
    println(a.numIslands(Array(
      Array('1','1','0','0','0'),
      Array('1','1','0','0','0'),
      Array('0','0','1','0','0'),
      Array('0','0','0','1','1')
    )))
  }
}
