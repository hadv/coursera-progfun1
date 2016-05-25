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
}
