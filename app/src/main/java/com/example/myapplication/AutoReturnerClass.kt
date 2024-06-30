package com.example.myapplication


class AutoReturnerClass {
    fun returnCar(numb : Int): Car{
        val year = 2000 + (Math.random() * 24).toInt()
        val horsePower = 70 + (Math.random() * 150).toInt()
        val brand = randomString((Math.random() * 15).toInt())
        val model = randomString((Math.random() * 15).toInt())
        val car = Car(brand = brand, model = model, yearOfRelease = year, horsePower = horsePower)
        car.numb = numb
        return car
    }

    fun randomString(numb : Int) : String {
        var chr = 0
        var ret = ""
        while (chr < numb){
            ret += (97 + (Math.random() * 25).toInt()).toChar()
            chr++;
        }
        return ret
    }
}