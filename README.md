[![Build Status](https://travis-ci.org/sczerwinski/coursera-progfun1.svg?branch=master)](https://travis-ci.org/sczerwinski/coursera-progfun1)

# Functional Programming Principles in Scala

This project contains source code written for peer-reviewed assignments in [Functional Programming Principles in Scala](https://www.coursera.org/learn/progfun1) course on [Coursera](https://www.coursera.org/).

## Assignment: Example Assignment

> The goal of this assignment is to familiarize yourself with the infrastructure and the tools required during this class. Even though the grade in this assignment will be excluded from your final grade for the course, it is important that you work through this assignment carefully.

## Assignment: Recursion

### Exercise 1: Pascal’s Triangle

> Do this exercise by implementing the `pascal` function in `Main.scala`, which takes a column `c` and a row `r`, counting from 0 and returns the number at that spot in the triangle. For example, `pascal(0,2)=1`,`pascal(1,2)=2` and `pascal(1,3)=3`.
> ```scala
> def pascal(c: Int, r: Int): Int
> ```

### Exercise 2: Parentheses Balancing

> Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a `List[Char]` not a `String`. For example, the function should return true for the following strings:
>  * (if (zero? x) max (/ 1 x))
>  * I told him (that it’s not (yet) done). (But he wasn’t listening)
>
> The function should return false for the following strings:
>  * :-)
>  * ())(
>
> The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.
>
> Do this exercise by implementing the `balance` function in `Main.scala`. Its signature is as follows:
> ```scala
> def balance(chars: List[Char]): Boolean
> ```

### Exercise 3: Counting Change

> Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.
>
> Do this exercise by implementing the `countChange` function in `Main.scala`. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:
> ```scala
> def countChange(money: Int, coins: List[Int]): Int
> ```

## Assignment: Functional Sets

> In this assignment, you will work with a functional representation of sets based on the mathematical notion of characteristic functions. The goal is to gain practice with higher-order functions.
>
> Write your own tests! For this assignment, we don’t give you tests but instead the `FunSetSuite.scala` file contains hints on how to write your own tests for the assignment.

### Representation

> We will work with sets of integers.
>
> As an example to motivate our representation, how would you represent the set of all negative integers? You cannot list them all… one way would be so say: if you give me an integer, I can tell you whether it’s in the set or not: for 3, I say ‘no’; for -1, I say yes.
>
> Mathematically, we call the function which takes an integer as argument and which returns a boolean indicating whether the given integer belongs to a set, the characteristic function of the set. For example, we can characterize the set of negative integers by the characteristic function `(x: Int) => x < 0`.
>
> Therefore, we choose to represent a set by its characterisitc function and define a type alias for this representation:
> ```scala
> type Set = Int => Boolean
> ```
>
> Using this representation, we define a function that tests for the presence of a value in a set:
> ```scala
> def contains(s: Set, elem: Int): Boolean = s(elem)
> ```

### 2.1 Basic Functions on Sets

> * Define a function which creates a singleton set from one integer value: the set represents the set of the one given element. Its signature is as follows: `def singletonSet(elem: Int): Set` Now that we have a way to create singleton sets, we want to define a function that allow us to build bigger sets from smaller ones.
> * Define the functions `union`, `intersect`, and `diff`, which takes two sets, and return, respectively, their union, intersection and differences. `diff(s, t)` returns a set which contains all the elements of the set `s` that are not in the set `t`. These functions have the following signatures: `def union(s: Set, t: Set): Set`, `def intersect(s: Set, t: Set): Set`, `def diff(s: Set, t: Set): Set`
> * Define the function `filter` which selects only the elements of a set that are accepted by a given predicate `p`. The filtered elements are returned as a new set. The signature of `filter` is as follows: `def filter(s: Set, p: Int => Boolean): Set`

### 2.2 Queries and Transformations on Sets

> In this part, we are interested in functions used to make requests on elements of a set. The first function tests whether a given predicate is true for all elements of the set. This `forall` function has the following signature:
> ```scala
> def forall(s: Set, p: Int => Boolean): Boolean
> ```
>
> Note that there is no direct way to find which elements are in a set. `contains` only allows to know whether a given element is included. Thus, if we wish to do something to all elements of a set, then we have to iterate over all integers, testing each time whether it is included in the set, and if so, to do something with it. Here, we consider that an integer `x` has the property `-1000 <= x <= 1000` in order to limit the search space.
>
> * Implement `forall` using linear recursion. For this, use a helper function nested in `forall`. Its structure is as follows (replace the `???`): `def forall(s: Set, p: Int => Boolean): Boolean = { def iter(a: Int): Boolean = { if (???) ??? else if (???) ??? else iter(???) } iter(???)}`
> * Using`forall`, implement a function `exists` which tests whether a set contains at least one element for which the given predicate is true. Note that the functions `forall` and `exists` behave like the universal and existential quantifiers of first-order logic. `def exists(s: Set, p: Int => Boolean): Boolean`
> * Finally, write a function `map` which transforms a given set into another one by applying to each of its elements the given function. `map` has the following signature: `def map(s: Set, f: Int => Int): Set`

