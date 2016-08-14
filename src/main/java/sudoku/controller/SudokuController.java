package sudoku.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sudoku.model.SudokuBaseResponse;
import sudoku.model.SudokuResponse;
import sudoku.service.SudokuService;

/**
 * Created by Ninyo on 10/01/2016.
 */
@RestController
@RequestMapping(value = "/sudoku")
public class SudokuController {

    private static final Logger logger = LoggerFactory.getLogger(SudokuController.class);

    @Autowired
    private SudokuService sudokuService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SudokuBaseResponse sudoku(
            @RequestParam(value = "num", required = false) Integer num,
            @RequestParam(value = "row", required = false) Integer row,
            @RequestParam(value = "col", required = false) Integer col) {

        if (num != null && row != null && col != null) {
            boolean isValidCandidate = sudokuService.isValidCandidate(num, row, col);
            boolean isPossibleSolution = sudokuService.setPossibleSolution(num, row, col);
            return new SudokuResponse(sudokuService.getBoard().getMatrix(), sudokuService.isSolved(), isValidCandidate, isPossibleSolution);
        }
        return new SudokuBaseResponse(sudokuService.getBoard().getMatrix(), sudokuService.isSolved());
    }

//    @ExceptionHandler
//    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    ErrorResponse handleException(UnsupportedOperationException exception) {
//        logger.error(exception.getMessage(), exception);
//        return new ErrorResponse(exception.getMessage());
//    }
}
