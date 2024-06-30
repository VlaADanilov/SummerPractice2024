package com.example.myapplication

class DieselCar(
    override val brand: String,
    override val model: String,
    override val horsePower: Int,
    override val yearOfRelease: Int,
    val dieselBackSize: Int,
    val threatToTheEnvironment: Int
) :
    Car(brand = brand, model = model, horsePower = horsePower, yearOfRelease = yearOfRelease) {

}