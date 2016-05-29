package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  trait MakeCodeTree {
    val sampleTree = makeCodeTree(
      makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2)
    )
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("weight of makeCodeTree") {
    new MakeCodeTree {
      assert(weight(sampleTree) === 4)
    }
  }

  test("chars of makeCodeTree") {
    new MakeCodeTree {
      assert(chars(sampleTree) === List('x', 'e', 't'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("makeOrderedLeafList for times for list of chars") {
    assert(makeOrderedLeafList(times(List('x', 't', 'e', 'x', 't', 'x'))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("until of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val fork = Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3)
    assert(until(singleton, combine)(leaflist) === Fork(fork, Leaf('x', 4), List('e', 't', 'x'), 7))
  }

  test("createCodeTree of some leaf list") {
    val chars = List('x', 't', 'e', 'x', 't', 'x', 'x')
    val fork = Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3)
    assert(createCodeTree(chars) === Fork(fork, Leaf('x', 4), List('e', 't', 'x'), 7))
  }


  test("decodedSecret") {
    assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("encode and decode secret should be identity") {
    new TestTrees {
      assert(encode(frenchCode)(decode(frenchCode, secret)) === secret)
    }
  }

}
