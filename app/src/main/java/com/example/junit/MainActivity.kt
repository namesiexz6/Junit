package com.example.junit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var btnCalculate: Button
    lateinit var tvLength: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvLength = findViewById(R.id.tvLength)

        btnCalculate.setOnClickListener {
            calculateLength(etName.text.toString())
        }
    }

    fun calculateLength(name: String) {
        when {
            name.isBlank() -> {
                tvLength.text = ""
                tvLength.visibility = View.GONE
            }
            else -> {
                val length = name.length
                tvLength.text = "Your name length is: $length"
                tvLength.visibility = View.VISIBLE
            }
        }
    }

    fun calculateLengthunit(name: String) =
        when {
            name.isBlank() -> {
                "Name is required field"
            }
            name.length < 6 -> {
                "Length of the Name should be greater than 6"
            }
            name.length > 15 -> {
                "Length of the Name be less than 15"
            }
            else -> {
                "Valid"
            }
        }

}
