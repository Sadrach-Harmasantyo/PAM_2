package com.example.pam_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
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

        val inputFirstNumber: EditText = findViewById(R.id.inputFirstNumber)
        val inputSecondNumber: EditText = findViewById(R.id.inputSecondNumber)
        val radioGroupOperations: RadioGroup = findViewById(R.id.radioGroupOperations)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val num1 = inputFirstNumber.text.toString().toDoubleOrNull()
            val num2 = inputSecondNumber.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedOperationId = radioGroupOperations.checkedRadioButtonId
            if (selectedOperationId == -1) {
                Toast.makeText(this, "Pilih operasi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (selectedOperationId) {
                R.id.radioAdd -> num1 + num2

                R.id.radioSubtract -> num1 - num2

                R.id.radioMultiply -> num1 * num2

                R.id.radioDivide -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    } else {
                        num1 / num2
                    }
                }

                else -> 0.0
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            intent.putExtra("NIM", "225150401111039")
            intent.putExtra("NAME", "Sadrach Harmasantyo")
            startActivity(intent)
        }
    }
}