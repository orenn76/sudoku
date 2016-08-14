package sudoku.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import sudoku.model.ErrorResponse;

/**
 * Test fixture for {@link GlobalExceptionHandler}.
 */
@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;
    private static final String FIRST_NAME = "firstName";
    private static final String ERROR_CODE = "empty.field";

    @Before
    public void setup() {
        this.exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testInternalServerError() {
        Exception ex = new ClassCastException("classCastException");
        ErrorResponse response = this.exceptionHandler.internalServerError(ex);
        assertEquals("classCastException", response.getMessage());
    }
}