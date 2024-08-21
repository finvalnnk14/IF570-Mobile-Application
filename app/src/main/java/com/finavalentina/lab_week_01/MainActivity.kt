package com.finavalentina.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val studentNumberDisplay = findViewById<TextView>(R.id.student_number_display)
        val btnSubmit = findViewById<Button>(R.id.button_submit)

        btnSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val studentNumberInput = findViewById<TextInputEditText>(R.id.student_number_input)
            ?.text.toString().trim()

            if(nameInput.isNotEmpty()){
                nameDisplay?.text = getString(R.string.name_greet).plus("").plus(nameInput)
                // or you can use
                // nameDisplay?.text = "${getString(R.string.name_greet)} ${nameInput}"
            } else if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }

            if (studentNumberInput.isNotEmpty()) {
                studentNumberDisplay?.text = getString(R.string.student_number_greet).plus("").plus(studentNumberInput)
            } else if (studentNumberInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.student_number_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}
