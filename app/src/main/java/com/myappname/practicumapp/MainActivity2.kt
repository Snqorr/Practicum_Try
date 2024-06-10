package com.myappname.practicumapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var Date: EditText
    private lateinit var MorningTime: EditText
    private lateinit var AfternoonTime: EditText
    private lateinit var Notes: EditText
    private lateinit var Savebtn: Button
    private lateinit var Clearbtn: Button
    private lateinit var Nextbtn: Button
    private lateinit var tvMessage: TextView

    private val dateArray= mutableListOf<String>()
    private val MorningArrayTime= mutableListOf<Float>()
    private val AfternoonArrayTime= mutableListOf<Float>()
    private val notesArray= mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        Date = findViewById(R.id.Date)
        MorningTime = findViewById(R.id.MorningTime)
        AfternoonTime = findViewById(R.id.AfternoonTime)
        Notes = findViewById(R.id.Notes)
        Savebtn = findViewById(R.id.Savebtn)
        Clearbtn = findViewById(R.id.Clearbtn)
        Nextbtn = findViewById(R.id.Nextbtn)
        tvMessage = findViewById(R.id.tvMessage)

        Clearbtn.setOnClickListener {
            Date.text.clear()
            MorningTime.text.clear()
            AfternoonTime.text.clear()
            Notes.text.clear()
        }

        Savebtn.setOnClickListener {
            val date = Date.text.toString()
            val morningTime = MorningTime.text.toString()
            val afternoonTime = AfternoonTime.text.toString()
            val notes = Notes.text.toString()

            if (date.isNotEmpty() && morningTime.isNotEmpty() && afternoonTime.isNotEmpty()){
                try {
                    dateArray.add(Date.toString())
                    MorningArrayTime.add(morningTime.toFloat())
                    AfternoonArrayTime.add(afternoonTime.toFloat())
                    notesArray.add(notes)
                    Date.text.clear()
                    MorningTime.text.clear()
                    AfternoonTime.text.clear()
                    Notes.text.clear()
                } catch (e: NumberFormatException){
                    tvMessage.text = "Please enter valid numbers"
                }
            } else {
                tvMessage.text = "Input cannot be empty"
            }
        }

        Nextbtn.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("dateArray", dateArray.toTypedArray())
            intent.putExtra("MorningArrayTime", MorningArrayTime.toFloatArray())
            intent.putExtra("AfternoonArrayTime", AfternoonArrayTime.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)
        }

    }
}
