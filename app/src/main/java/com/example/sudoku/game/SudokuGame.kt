package com.example.sudoku.game

import androidx.lifecycle.MutableLiveData

class SudokuGame {

    var selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()
    var cellsLiveData = MutableLiveData<List<Cell>>()
    val isTakingNotesLiveData = MutableLiveData<Boolean>()
    val highlightedKeysLiveData = MutableLiveData<Set<Int>>()

    private var selectedRow = -1
    private var selectedCol = -1
    private var isTakingNotes = false

    private val board: Board

    init {
        val cells = List(9 * 9){i -> Cell(i / 9 , i % 9, i % 9)}
        cells[0].notes = mutableSetOf(1,2,3,4,5,6,7,8,9)
        board = Board(9, cells)

        selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
        cellsLiveData.postValue(board.cells)

        isTakingNotesLiveData.postValue(isTakingNotes)
    }

    fun handleInput(number: Int){
        if(selectedRow == -1 || selectedCol == -1) return
        var cell = board.getCell(selectedRow, selectedCol)
        if(cell.isStartingCell) return

        if(isTakingNotes){
            if(cell.notes.contains(number)){
                cell.notes.remove(number)
            }else{
                cell.notes.add(number)
            }
            highlightedKeysLiveData.postValue(cell.notes)
        }else {
            cell.value = number
        }
        cellsLiveData.postValue(board.cells)
    }

    fun updateSelectedCell(row: Int, col: Int){
        val cell = board.getCell(row, col)
        if(!board.getCell(row, col).isStartingCell) {
            selectedRow = row
            selectedCol = col
            selectedCellLiveData.postValue(Pair(row, col))
        }

        if(isTakingNotes){
            highlightedKeysLiveData.postValue(cell.notes)
        }
    }

    fun changeNoteTakingState(){
        
    }
}