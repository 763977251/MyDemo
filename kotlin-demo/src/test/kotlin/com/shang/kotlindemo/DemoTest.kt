package com.shang.kotlindemo

var name = "shang"
var age = 28

fun main() {
    println("$name  $age")

    var c = add(1,4)
    println(c);
}

fun add(a: Int, b: Int): Int {
    return a + b
}
