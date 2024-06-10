package com.rose.practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class HomePage : AppCompatActivity() {

    private lateinit var etDate: EditText
    private lateinit var etLowTemp: EditText
    private lateinit var etHighTemp: EditText
    private lateinit var etNote: EditText

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button
    private lateinit var btnNext: Button

    private lateinit var textView2: TextView

    private val dateArray = mutableListOf<String>()
    private val tempArrayLow = mutableListOf<Float>()
    private val tempArrayHigh = mutableListOf<Float>()
    private val notesArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        btnSave = findViewById(R.id.btnSave)
        btnClear = findViewById(R.id.btnClear)
        btnNext = findViewById(R.id.btnNext)

        etDate = findViewById(R.id.etDate)
        etHighTemp = findViewById(R.id.etHighTemp)
        etLowTemp = findViewById(R.id.etLowTemp)
        etNote = findViewById(R.id.etNote)


        //button to clear the incorrect data

        btnClear.setOnClickListener {
            etDate.setText("")
            etLowTemp.setText("")
            etHighTemp.setText("")
            etNote.setText("")
        }

        //button to store the data in an array as well as creating values and variables

        btnSave.setOnClickListener {
            val screenTimeDate = etDate.text.toString()
            val screenTimeLowest = etLowTemp.text.toString()
            val screenTimeHighest = etHighTemp.text.toString()
            val screenTimeNotes = etNote.text.toString()

            //error message to display should the user input be incorrect

            if (screenTimeDate.isNotEmpty()&& screenTimeLowest.isNotEmpty()&& screenTimeHighest.isNotEmpty()) {
                try{
                    dateArray.add(screenTimeDate)
                    tempArrayLow.add(screenTimeLowest.toFloat())
                    tempArrayHigh.add(screenTimeHighest.toFloat())
                    notesArray.add(screenTimeNotes)
                    etDate.text.clear()
                    etLowTemp.text.clear()
                    etHighTemp.text.clear()
                    etNote.text.clear()
                } catch (e: NumberFormatException){
                    textView2.text = "Please enter a valid number"
                }
            } else{
                textView2.text = "Input cannot be empty"
            }
        }

        //button that transfers the stored data into the 'next page' to be displayed

        btnNext.setOnClickListener {
            val intent = Intent (this, DetailedView::class.java)
            intent. putExtra("dateArray", dateArray.toTypedArray())
            intent.putExtra("tempArrayLow",tempArrayLow.toFloatArray())
            intent.putExtra("tempArrayHigh", tempArrayHigh.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)
        }

    }
}