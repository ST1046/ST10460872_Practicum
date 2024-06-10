package com.rose.practicum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.text.StringBuilder

class DetailedView : AppCompatActivity() {

    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView4: TextView
    private lateinit var button2: Button
    private lateinit var textViewAverageTemp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        button2 = findViewById(R.id.button2)
        textViewAverageTemp = findViewById(R.id.textViewAverageTemp)

        //initialising the values

        val dateArray = intent.getStringArrayExtra("dateArray")?.toList() ?: emptyList()
        val tempArrayLow = intent.getFloatArrayExtra("tempArrayLow")?.toList() ?: emptyList()
        val tempArrayHigh = intent.getFloatArrayExtra("tempArrayHigh")?.toList() ?: emptyList()
        val notesArray= intent.getStringArrayExtra("notesArray")?.toList() ?: emptyList()

        //to calculate the average temp during the week

        val sum = tempArrayLow.sum() + tempArrayHigh.sum()
        val average = sum/(tempArrayLow.size + tempArrayHigh.size)
        textViewAverageTemp.text = "Average temperature for the week: $average"

        //sorting the information and calling on the data

        val dated = StringBuilder()
        for((index, date)in dateArray.withIndex()){
            dated.append("Day $index: $date \n")
        }
        val tempLO = StringBuilder()
        for ((index, temp ) in tempArrayLow.withIndex()){
           tempLO.append("Lowest Temp $index: $temp \n")
        }
        val tempHI = StringBuilder()
        for ((index, temp ) in tempArrayHigh.withIndex()){
            tempHI.append("Highest Temp $index: $temp \n")
        }
        val noted = StringBuilder()
        for ((index, note) in notesArray.withIndex()){
            noted.append("Note $index: $note \n")
        }

        //displaying the data using textViews

        textView4.text = dated.toString()
        textView5.text = tempLO.toString()
        textView6.text = tempHI.toString()
        textView7.text = noted.toString()

        //button to return to the home page/previous page

        button2.setOnClickListener {
            finish()


        }
    }
}