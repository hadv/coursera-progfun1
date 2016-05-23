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

