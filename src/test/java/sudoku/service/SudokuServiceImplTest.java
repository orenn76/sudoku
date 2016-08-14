package sudoku.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import sudoku.model.Board;
import sudoku.utils.SudokuSolver;

/**
 * Created by Ninyo on 10/01/2016.
 * Test for {@link SudokuServiceImpl}.
 */
@RunWith(MockitoJUnitRunner.class)
public class SudokuServiceImplTest {

    @Mock
    private SudokuSolver sudokuSolver;

    @InjectMocks
    private SudokuServiceImpl sudokuServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(sudokuSolver.getBoard()).thenReturn(getMockedBoard());
        Mockito.when(sudokuSolver.isSolved()).thenReturn(true);
        Mockito.when(sudokuSolver.isValidCandidate(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        Mockito.when(sudokuSolver.setPossibleSolution(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
    }

    @Test
    public void testGetBoard() {
        int[][] matrix = sudokuServiceImpl.getBoard().getMatrix();
        Assert.assertEquals(matrix[0].length, getMockedBoard().getMatrix()[0].length);
    }

    @Test
    public void testIsSolved() {
        boolean isSolved = sudokuServiceImpl.isSolved();
        Assert.assertEquals(true, isSolved);
    }

    @Test
    public void testIsValidCandidate() {
        boolean isValidCandidate = sudokuServiceImpl.isValidCandidate(1, 1, 1);
        Assert.assertEquals(true, isValidCandidate);
    }

    @Test
    public void testSetPossibleSolution() {
        boolean isSet = sudokuServiceImpl.setPossibleSolution(1, 1, 1);
        Assert.assertEquals(true, isSet);
    }

    private Board getMockedBoard(){
        int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
                {0, 0, 5, 0, 0, 8, 0, 1, 0},
                {0, 0, 8, 5, 0, 9, 0, 4, 0},
                {5, 3, 9, 0, 6, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 5},
                {8, 0, 0, 7, 2, 0, 9, 0, 0},
                {9, 0, 7, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 7, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 5, 0}};

        return new Board(matrix);
    }

}
