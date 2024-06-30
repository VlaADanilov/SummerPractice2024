package com.example.myapplication

class ElectroCar(
    override val brand: String,
    override val model: String,
    override val horsePower: Int,
    override val yearOfRelease: Int,
    val batterySize: Int,
    val systemII: String
) :
    Car(brand = brand, model = model, horsePower = horsePower, yearOfRelease = yearOfRelease) {

}