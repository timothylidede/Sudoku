package com.example.sudoku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val startCard = findViewById<CardView>(R.id.start_card)
        startCard.setOnClickListener {
            val intent = Intent(this, PlaySudokuActivity::class.java)
            startActivity(intent)
        }
    }
}