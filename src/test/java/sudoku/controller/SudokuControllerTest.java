package sudoku.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sudoku.model.Board;
import sudoku.service.SudokuService;

/**
 * Created by Ninyo on 10/01/2016.
 * Test for {@link SudokuController}.
 */
@RunWith(MockitoJUnitRunner.class)
public class SudokuControllerTest {

    private static final String GET_URL = "/sudoku";

    @Mock
    private SudokuService sudokuService;

    private MockMvc mockMvc;

    @InjectMocks
    private SudokuController sudokuController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(sudokuService.getBoard()).thenReturn(getMockedBoard());
        Mockito.when(sudokuService.isSolved()).thenReturn(true);
        Mockito.when(sudokuService.isValidCandidate(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        Mockito.when(sudokuService.setPossibleSolution(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        this.mockMvc = MockMvcBuilders.standaloneSetup(sudokuController).build();
    }

    @Test
    public void testSearchAndImportVideos() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(GET_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
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
