package funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val integers: Set = { x => true }
    val positive: Set = { x => x > 0 }
    val negative: Set = { x => x < 0 }

    val even: Set = { x => x % 2 == 0 }
    val odd: Set = { x => x % 2 != 0 }
  }

  test("singletonSet(1) contains 1") {
    new TestSets {
      assert(contains(s1, 1), "Singleton")
      assert(!contains(s1, 2), "Singleton")
      assert(!contains(s1, 3), "Singleton")
    }
  }

  test("singletonSet(2) contains 2") {
    new TestSets {
      assert(!contains(s2, 1), "Singleton")
      assert(contains(s2, 2), "Singleton")
      assert(!contains(s2, 3), "Singleton")
    }
  }

  test("singletonSet(3) contains 3") {
    new TestSets {
      assert(!contains(s3, 1), "Singleton")
      assert(!contains(s3, 2), "Singleton")
      assert(contains(s3, 3), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersection contains elements that are in both set") {
    new TestSets {
      val s12 = union(s1, s2)
      val s13 = union(s1, s3)
      val s = intersect(s12, s13)
      assert(contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }

  test("difference contains elements from first set that are not in second set") {
    new TestSets {
      val s12 = union(s1, s2)
      val s13 = union(s1, s3)
      val s = diff(s12, s13)
      assert(!contains(s, 1), "Diff 1")
      assert(contains(s, 2), "Diff 2")
      assert(!contains(s, 3), "Diff 3")
    }
  }

  test("filter accepts only certain elements of the set") {
    new TestSets {
      val s = filter(integers, x => x % 2 == 0)
      assert(contains(s, 0), "Filter 0")
      assert(!contains(s, 1), "Filter 1")
      assert(contains(s, 2), "Filter 2")
      assert(!contains(s, 3), "Filter 3")
    }
  }

  test("all numbers in singletonSet(1) are equal to 1") {
    new TestSets {
      assert(forall(s1, x => x == 1))
    }
  }

  test("all integer numbers are equal to themselves") {
    new TestSets {
      assert(forall(s1, x => x == x))
    }
  }

  test("negation of every positive number is negative") {
    new TestSets {
      assert(forall(positive, x => contains(negative, -x)))
    }
  }

  test("not all integers are even") {
    new TestSets {
      assert(!forall(integers, x => contains(even, x)))
    }
  }

  test("all odd numbers, when incremented by 1, are even") {
    new TestSets {
      assert(forall(odd, x => contains(even, x + 1)))
    }
  }

  test("exists a positive number equal to 1") {
    new TestSets {
      assert(exists(positive, x => x == 1))
    }
  }

  test("exists a positive number which is even") {
    new TestSets {
      assert(exists(positive, x => contains(even, x)))
    }
  }

  test("does not exist any positive number which is negative") {
    new TestSets {
      assert(!exists(positive, x => contains(negative, x)))
    }
  }

  test("singletonSet(1) map add 1") {
    new TestSets {
      val s = map(s1, x => x + 1)
      assert(!contains(s2, 1), "Singleton + 1")
      assert(contains(s2, 2), "Singleton + 1")
      assert(!contains(s2, 3), "Singleton + 1")
    }
  }

  test("all even numbers, when incremented by 1, are odd") {
    new TestSets {
      assert(forall(map(even, x => x + 1), x => contains(odd, x)))
    }
  }

  test("all integer numbers, when multiplied by 2, are even") {
    new TestSets {
      assert(forall(map(integers, x => x * 2), x => contains(even, x)))
    }
  }
}
