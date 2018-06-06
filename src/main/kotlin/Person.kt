package vibe.learning.kotlin

class Person(var name: String) {
    constructor() : this("NoName")

    fun greet(): String = "Hi $name"

}
