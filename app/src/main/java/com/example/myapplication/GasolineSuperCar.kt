package com.example.myapplication

class GasolineSuperCar(
    override val brand: String,
    override val model: String,
    override val horsePower: Int,
    override val yearOfRelease: Int,
    val cisternSize: Int,
    val turboType: String
) :
    Car(brand = brand, model = model, horsePower = horsePower, yearOfRelease = yearOfRelease) {

}