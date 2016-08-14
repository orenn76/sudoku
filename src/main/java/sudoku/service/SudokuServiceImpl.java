package sudoku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sudoku.model.Board;
import sudoku.utils.SudokuSolver;

/**
 * Created by Ninyo on 14/08/2016.
 */
@Component
public class SudokuServiceImpl implements SudokuService {

    @Autowired
    private SudokuSolver sudokuSolver;

    @Override
    public Board getBoard() {
        return sudokuSolver.getBoard();
    }

    @Override
    public boolean isSolved() {
        return sudokuSolver.isSolved();
    }

    @Override
    public boolean isValidCandidate(int num, int row, int col) {
        return sudokuSolver.isValidCandidate(num, row, col);
    }

    @Override
    public boolean setPossibleSolution(int num, int row, int col) {
        return sudokuSolver.setPossibleSolution(num, row, col);
    }
}
