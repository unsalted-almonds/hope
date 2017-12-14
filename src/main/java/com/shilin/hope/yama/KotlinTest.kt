package com.shilin.hope.yama


/**
 * Created by Shilin_Gan on 12/14/2017.
 */


//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

fun sum(a: Int, b: Int) = a + b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))

    var myVar = "gary"
    val s1 = "my name is $myVar"

    println(s1)

    myVar = "shilin"
    val s2 = "my name is $myVar"

    println(s2)
}

