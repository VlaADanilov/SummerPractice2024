package com.example.myapplication

class GasolineClassicCar(
    override val brand: String,
    override val model: String,
    override val horsePower: Int,
    override val yearOfRelease: Int,
    val cisternSize: Int,
) :
    Car(brand = brand, model = model, horsePower = horsePower, yearOfRelease = yearOfRelease) {

}