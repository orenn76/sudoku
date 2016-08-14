package sudoku.service;

import sudoku.model.Board;

/**
 * Created by Ninyo on 14/08/2016.
 */
public interface SudokuService {

    Board getBoard();

    boolean isSolved();

    boolean isValidCandidate(int num, int row, int col);

    boolean setPossibleSolution(int num, int row, int col);
}
