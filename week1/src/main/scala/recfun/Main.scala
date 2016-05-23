package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def loop(level: Int, char: Char, chars: List[Char]): Boolean = {

        val newLevel =
          char match {
            case '(' => level + 1
            case ')' => level - 1
            case default => level
          }

        if (newLevel < 0) false
        else if (chars.isEmpty) newLevel == 0
        else loop(newLevel, chars.head, chars.tail)
      }

      loop(0, chars.head, chars.tail)
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
