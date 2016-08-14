package sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Ninyo on 10/01/2016.
 */
@JsonPropertyOrder({ "currentBoard", "isSolved", "isValidCandidate", "isPossibleSolution" })
public class SudokuResponse extends SudokuBaseResponse {

    private boolean isValidCandidate;
    private boolean isPossibleSolution;

    public SudokuResponse(int[][] currentBoard, boolean isSolved, boolean isValidCandidate, boolean isPossibleSolution) {
        super(currentBoard, isSolved);
        this.isValidCandidate = isValidCandidate;
        this.isPossibleSolution = isPossibleSolution;
    }

    @JsonProperty("isValidCandidate")
    public boolean isValidCandidate() {
        return isValidCandidate;
    }

    @JsonProperty("isValidCandidate")
    public void setValidCandidate(boolean validCandidate) {
        isValidCandidate = validCandidate;
    }

    @JsonProperty("isPossibleSolution")
    public boolean isPossibleSolution() {
        return isPossibleSolution;
    }

    @JsonProperty("isPossibleSolution")
    public void setPossibleSolution(boolean possibleSolution) {
        isPossibleSolution = possibleSolution;
    }

}

