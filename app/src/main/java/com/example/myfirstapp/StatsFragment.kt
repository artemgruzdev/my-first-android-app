package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StatsFragment : Fragment() {

    private lateinit var textViewAge: TextView
    private lateinit var textYearBirth: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stats, container, false)
        textViewAge = view.findViewById(R.id.textViewAge)
        textYearBirth = view.findViewById(R.id.textViewYearBirth)
        return view
    }

    fun updateStats(age: Int, yearBirth: Int) {
        textViewAge.text = "Возраст: $age"
        textYearBirth.text = "Год рождения: $yearBirth"
    }
}