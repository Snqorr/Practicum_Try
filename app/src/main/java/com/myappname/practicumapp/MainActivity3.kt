package com.myappname.practicumapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private lateinit var Backbtn: Button
    private lateinit var tvDetails: TextView
    private lateinit var tvNotes: TextView
    private lateinit var tvHoursAM: TextView
    private lateinit var tvHoursPM: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        Backbtn = findViewById(R.id.Backbtn)
        tvDetails = findViewById(R.id.tvDetails)
        tvNotes = findViewById(R.id.tvNotes)
        tvHoursAM = findViewById(R.id.tvHoursAM)
        tvHoursPM = findViewById(R.id.tvHoursPM)

        val dateArray = intent.getStringArrayExtra("dateArray")?.toList()?: emptyList()
        val morningArrayTime = intent.getFloatArrayExtra("MorningArrayTime")?.toList()?: emptyList()
        val afternoonArrayTime = intent.getFloatArrayExtra("AfternoonArrayTime")?.toList()?: emptyList()
        val notesArray = intent.getStringArrayExtra("notesArray")?.toList()?: emptyList()

        val dated = StringBuilder()
        for ((index, date) in dateArray.withIndex()){
            dated.append("Day ${index + 1}:$date\n")
        }
        val hoursAM = StringBuilder()
        for ((index, morningTime) in morningArrayTime.withIndex()){
            hoursAM.append("Day ${index + 1}:$morningTime")
        }
        val hoursPM = StringBuilder()
        for ((index, afternoonTime) in afternoonArrayTime.withIndex()){
            hoursPM.append("Day ${index + 1}:$afternoonTime")
        }
        val notes = StringBuilder()
        for ((index, note) in notesArray.withIndex()){
            notes.append("Day ${index + 1}:$note")
        }

        tvDetails.text = dated.toString()
        tvHoursAM.text = hoursAM.toString()
        tvHoursPM.text = hoursPM.toString()
        tvNotes.text = notes.toString()

        Backbtn.setOnClickListener {
            finish()
        }
    }
}
