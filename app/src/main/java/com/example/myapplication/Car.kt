package com.example.myapplication

open class Car (
    open val brand: String,
    open val model: String,
    open val horsePower: Int,
    open val yearOfRelease: Int,
){
    var numb : Int = -1

    override fun toString(): String {
        return "|brand: $brand, model: $model, year: $yearOfRelease, horsePower: $horsePower|"
    }

}