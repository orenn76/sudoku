package sudoku.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sudoku.model.Board;
import sudoku.utils.SudokuSolver;

/**
 * Configuration for external clients.
 */
@Configuration
public class SudokuConfig {

    /**
     * Provides a instance of sudoku solver.
     *
     * @return SudokuSolver.
     */
    @Bean
    public SudokuSolver getSudokuSolver() {
        int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
                {0, 0, 5, 0, 0, 8, 0, 1, 0},
                {0, 0, 8, 5, 0, 9, 0, 4, 0},
                {5, 3, 9, 0, 6, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 5},
                {8, 0, 0, 7, 2, 0, 9, 0, 0},
                {9, 0, 7, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 7, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 5, 0}};
        return new SudokuSolver(new Board(matrix));
    }
}
