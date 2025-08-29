package com.example.habittrackerliteapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var habitAdapter: HabitAdapter
    private lateinit var rvHabits: RecyclerView

    private val habits = mutableListOf(
        Habit("Drink 2L water"),
        Habit("Read 10 pages"),
        Habit("Exercise 30 mins"),
        Habit("Meditate 10 mins"),
        Habit("Write Journal")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvHabits = findViewById(R.id.rvHabits)
        habitAdapter = HabitAdapter(habits)

        rvHabits.layoutManager = LinearLayoutManager(this)
        rvHabits.adapter = habitAdapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}