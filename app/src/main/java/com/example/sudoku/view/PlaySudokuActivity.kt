package com.example.sudoku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sudoku.R
import com.example.sudoku.viewmodel.PlaySudokuViewModel
import kotlinx.android.synthetic.main.activity_play_sudoku.*


class PlaySudokuActivity : AppCompatActivity() {

    private lateinit var viewModel: PlaySudokuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_sudoku)

        viewModel = ViewModelProviders.of(this)
            .get(PlaySudokuViewModel::class.java)
        viewModel.sudokuGame.selectedCellLiveData.observe(this, Observer { 
            updateSelectedCellUI(it)
        })
    }

    private fun updateSelectedCellUI(cell: Pair<Int, Int>?) = cell?.let{
        sudokuBoardView.updateSelectedCellUI(cell.first, cell.second)
    }
}