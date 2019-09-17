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
//  object SimpleDatabase {
//    def allFoods = List(Apple, Orange, Cream, Sugar)
//
//    def foodNamed(name: String): Option[Food] =
//      allFoods.find(_.name == name)
//
//    def allRecipes: List[Recipe] = List(FruitSalad)
//  }
//
//  object SimpleBrowser {
//    def recipesUsing(food: Food) =
//      SimpleDatabase.allRecipes.filter(recipe =>
//        recipe.ingredients.contains(food))
//  }
//object SimpleDatabase {
//  def allFoods = List(Apple, Orange, Cream, Sugar)
//
//  def foodNamed(name: String): Option[Food] =
//    allFoods.find(_.name == name)
//
//  def allRecipes: List[Recipe] = List(FruitSalad)
//
//  case class FoodCategory(name: String, foods: List[Food])
//
//  private var categories = List(
//    FoodCategory("fruits", List(Apple, Orange)),
//    FoodCategory("misc", List(Cream, Sugar)))
//
//  def allCategories = categories
//}

//  object SimpleBrowser {
//    def recipesUsing(food: Food) =
//      SimpleDatabase.allRecipes.filter(recipe =>
//        recipe.ingredients.contains(food))
//
//    def displayCategory(category: SimpleDatabase.FoodCategory) = {
//      println(category)
//    }
//  }

  abstract class Browser {
    val database: Database

    def recipesUsing(food: Food) =
      database.allRecipes.filter(recipe =>
        recipe.ingredients.contains(food))

    def displayCategory(category: database.FoodCategory) = {
      println(category)
    }
  }
//  abstract class Database {
//    def allFoods: List[Food]
//    def allRecipes: List[Recipe]
//
//    def foodNamed(name: String) =
//      allFoods.find(f => f.name == name)
//
//    case class FoodCategory(name: String, foods: List[Food])
//    def allCategories: List[FoodCategory]
//  }
//  object SimpleDatabase extends Database {
//    def allFoods = List(Apple, Orange, Cream, Sugar)
//
//    def allRecipes: List[Recipe] = List(FruitSalad)
//
//    private var categories = List(
//      FoodCategory("fruits", List(Apple, Orange)),
//      FoodCategory("misc", List(Cream, Sugar)))
//
//    def allCategories = categories
//  }
  object SimpleBrowser extends Browser {
    val database = SimpleDatabase
  }

  object StudentDatabase extends Database {
    object FrozenFood extends Food("FrozenFood")

    object HeatItUp extends Recipe(
      "heat it up",
      List(FrozenFood),
      "Microwave the 'food' for 10 minutes.")

    def allFoods = List(FrozenFood)
    def allRecipes = List(HeatItUp)
    def allCategories = List(
      FoodCategory("edible", List(FrozenFood)))
  }

  object StudentBrowser extends Browser {
    val database = StudentDatabase
  }

  trait FoodCategories {
    case class FoodCategory(name: String, foods: List[Food])
    def allCategories: List[FoodCategory]
  }
  abstract class Database extends FoodCategories {
    def allFoods: List[Food]
    def allRecipes: List[Recipe]
    def foodNamed(name: String) =
      allFoods.find(f => f.name == name)
  }
  object SimpleDatabase extends Database
    with SimpleFoods with SimpleRecipes
  trait SimpleFoods {
    object Pear extends Food("Pear")
    def allFoods = List(Apple, Pear)
    def allCategories = Nil
  }
  trait SimpleRecipes {
    this: SimpleFoods =>

    object FruitSalad extends Recipe(
      "fruit salad",
      List(Apple, Pear),   // Now Pear is in scope
      "Mix it all together."
    )
    def allRecipes = List(FruitSalad)
  }

  def main(args: Array[String]) {
    val apple = SimpleDatabase.foodNamed("Apple").get
    println(1, apple)
    println(2, SimpleBrowser.recipesUsing(apple))

    val db: Database =
      if(args(0) == "student")
        StudentDatabase
      else
        SimpleDatabase

    object browser extends Browser {
      val database = db
    }

    val apple1 = SimpleDatabase.foodNamed("Apple").get

    for(recipe <- browser.recipesUsing(apple1))
      println(recipe)


    val category = StudentDatabase.allCategories.head
    println(3, category)
  }

}
