package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numbField : EditText = findViewById(R.id.number_field)
        val button : Button = findViewById(R.id.button)
        val rezult : TextView = findViewById(R.id.rezult)


        rezult.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener {
            rezult.text = ""
            val number = numbField.text.toString().toInt()
            val list= ArrayList<Car>();
            pull(list, number)
            going(list, rezult)
        }
    }

    private fun pull(list: ArrayList<Car>, numb : Int){
        val arc = AutoReturnerClass()
        var chr = 0
        while(chr < numb){
            list.add(arc.returnCar(chr + 1))
            chr++;
        }
    }

    @SuppressLint("SetTextI18n")
    private fun going(list: ArrayList<Car>, rezult : TextView){
        var firstList = list
        while(firstList.size > 1){
            rezult.text = (rezult.text.toString() + "\n \n Новый круг!")
            var tempList = ArrayList<Car>()
            while (firstList.size > 1){
                var ind1 = (Math.random() * firstList.size).toInt()
                var ind2 = (Math.random() * firstList.size).toInt()
                while (ind2 == ind1){
                    ind2 = (Math.random() * firstList.size).toInt()
                }
                if (ind1 == firstList.size) ind1 -= 1
                if (ind2 == firstList.size) ind2 -= 1
                tempList.add(startRace(ind1 = ind1, ind2 = ind2, list = firstList, rezult = rezult))
            }
            if (firstList.size == 1) {
                var cr : Car = firstList[0]
                rezult.text = (rezult.text.toString() + "\n Машина ${cr.numb} не нашла пару и прошла дальше")
                tempList.add(cr)
            }
            firstList = tempList
        }
        println(firstList[0])
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    private fun startRace(ind1 : Int, ind2 : Int, list : ArrayList<Car>, rezult: TextView): Car {

        val car1 = list[ind1]
        val car2 = list[ind2]

        list.removeAt(ind1)

        if (ind2 > ind1) list.removeAt(ind2 - 1)
        else list.removeAt(ind2)

        //println("Заезд между $car1 и $car2")
        rezult.text = (rezult.text.toString() + "\n --- Заезд между ${car1.numb} и ${car2.numb}")
        if (car1.horsePower > car2.horsePower){
            //println("Победила машина $car1")
            rezult.text = (rezult.text.toString() + "\n Победила машина ${car1.numb}")
            return car1
        }
        if (car1.horsePower < car2.horsePower){
            //println("Победила машина $car2")
            rezult.text = (rezult.text.toString() + "\n Победила машина ${car2.numb}")
            return car2
        }
        if ((Math.random() * 100).toInt() > 50) {
            //println("Победила машина $car1")
            rezult.text = (rezult.text.toString() + "\n Победила машина ${car1.numb}")
            return car1
        }
        else
        //println("Победила машина $car2")
        rezult.text = (rezult.text.toString() + "\n Победила машина ${car2.numb}")
        return car2
    }
}


