package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var age: Int = 25
    val currentYear = 2024
    var yearOfBirth = calculateYearOfBirth(currentYear, age)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name: String = "Артем"

        if (savedInstanceState != null) {
            age = savedInstanceState.getInt(KEY_AGE, 25)
            yearOfBirth = savedInstanceState.getInt(KEY_YEAR_OF_BIRTH, 2024)
        }

        Log.d("MyApp", "Год рождения: $yearOfBirth")
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        textView.text = "Привет, $name"
        button.setOnClickListener {
            var newName = editText.text.toString()
            if (newName == "") newName = "Гость"
            age += 1
            yearOfBirth = calculateYearOfBirth(currentYear, age)
            textView.text = "Привет, $newName! Тебе $age лет. Год рождения: $yearOfBirth"
            Log.d("MyApp", "Возраст: $age. Год рождения: $yearOfBirth")
            editText.text.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_AGE, age)
        outState.putInt(KEY_YEAR_OF_BIRTH, yearOfBirth)
    }

    fun calculateYearOfBirth(currentYear: Int, age: Int): Int {
        return currentYear - age
    }

    companion object {
        const val KEY_AGE = "AGE"
        const val KEY_YEAR_OF_BIRTH = "YEAR_OF_BIRTH"
    }
}