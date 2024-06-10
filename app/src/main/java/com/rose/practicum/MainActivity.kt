package com.rose.practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnContinue: Button
    private lateinit var btnLeave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinue = findViewById(R.id.btnContinue)
        btnLeave = findViewById(R.id.btnLeave)

        //button to lead users to the next page

        btnContinue.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        //button to exit application

        btnLeave.setOnClickListener {
            finish()
        }
    }

}