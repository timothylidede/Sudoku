package com.example.sudoku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.sudoku.R
import com.example.sudoku.viewmodel.PlaySudokuViewModel

class PlaySudokuActivity : AppCompatActivity() {

    private lateinit var viewModel: PlaySudokuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_sudoku)

        viewModel = ViewModelProviders.of(this)
            .get(PlaySudokuViewModel::class.java)
    }
}