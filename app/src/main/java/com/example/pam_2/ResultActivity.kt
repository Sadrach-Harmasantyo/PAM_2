package com.example.pam_2

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pam_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val textViewNim: TextView = findViewById(R.id.textViewNim)
        val textViewName: TextView = findViewById(R.id.textViewName)

        // Get the data from the intent
        val result = intent.getDoubleExtra("RESULT", 0.0)
        val nim = intent.getStringExtra("NIM")
        val name = intent.getStringExtra("NAME")

        // Set the text for each TextView
        textViewResult.text = "Hasil: $result"
        textViewNim.text = "NIM: $nim"
        textViewName.text = "Nama: $name"
    }
}