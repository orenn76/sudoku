package sudoku.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sudoku.model.ErrorResponse;

/**
 * Exception handler that maps exceptions on response status codes.
 */
@ControllerAdvice(basePackageClasses = SudokuController.class)
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(SudokuController.class);

    /**
     * Handles all errors that are not handled specifically by another handler and returns 500.
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse internalServerError(final Throwable exception) {
        logger.error("Internal Server Error: " + exception.getMessage(), exception);
        return new ErrorResponse(exception.getMessage());
    }
}