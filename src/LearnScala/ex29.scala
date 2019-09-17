package LearnScala

/**
  * Created by lyk on 2019-9-17.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex29 {

  abstract class Food(val name: String) {
    override def toString = name
  }
  class Recipe(
                val name: String,
                val ingredients: List[Food],
                val instructions: String
              ) {
    override def toString = name
  }
  object Apple extends Food("Apple")
  object Orange extends Food("Orange")
  object Cream extends Food("Cream")
  object Sugar extends Food("Sugar")

  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Orange, Cream, Sugar),
    "Stir it all together."
  )
  object SimpleDatabase {
    def allFoods = List(Apple, Orange, Cream, Sugar)

    def foodNamed(name: String): Option[Food] =
      allFoods.find(_.name == name)

    def allRecipes: List[Recipe] = List(FruitSalad)
  }

  object SimpleBrowser {
    def recipesUsing(food: Food) =
      SimpleDatabase.allRecipes.filter(recipe =>
        recipe.ingredients.contains(food))
  }
  def main(args: Array[String]) {
    val apple = SimpleDatabase.foodNamed("Apple").get
    println(1, apple)
  }
}
