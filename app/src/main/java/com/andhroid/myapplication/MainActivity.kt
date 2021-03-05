package com.andhroid.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var n: IntArray = intArrayOf(10, 11)
    val m = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        methodInvokation()

        listOf(1, 2, 3).fold(0) { sum, element -> sum + element }
        listOf(1, 2, 3).reduce() { sum, element -> sum + element }
        n = intArrayOf(11, 12)

        when (m) {
            1 -> println("One")
            2, 3 -> println("2 , 3")
            else -> println("4")
        }

        when {
            m < 1 -> println("One")
            m > 1 -> println("One")
        }


        var b: String? = "abc"
        b = null // ok
        print(b)

        describe("Sandeep")



    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                true -> "teue"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "no string"
                else -> "Unknown"
            }

    fun methodInvokation() {
        print("sandee")

    }
}
