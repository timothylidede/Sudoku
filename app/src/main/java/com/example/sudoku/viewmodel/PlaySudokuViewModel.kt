package com.example.sudoku.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sudoku.game.SudokuGame

class PlaySudokuViewModel: ViewModel() {
    val sudokuGame = SudokuGame()
}