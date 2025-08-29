package com.example.habittrackerliteapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HabitAdapter(private val habits:MutableList<Habit>) :
        RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {


    inner class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHabitName:TextView = itemView.findViewById(R.id.tvHabitName)
        val btnComplete: Button = itemView.findViewById(R.id.btnComplete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_habit,parent,false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habits[position]
        holder.tvHabitName.text = habit.name




        //update ui if completed
        if(habit.isCompleted) {
            holder.tvHabitName.paintFlags = holder.tvHabitName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            holder.btnComplete.isEnabled = false
            holder.btnComplete.text = "Completed"
        }
        else {
            holder.tvHabitName.paintFlags = holder.tvHabitName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            holder.btnComplete.isEnabled = true
            holder.btnComplete.text = "Mark Complete"
        }


        //btn click listener
        holder.btnComplete.setOnClickListener {
            if(!habit.isCompleted) {
                habit.isCompleted = true
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return habits.size
    }

        }