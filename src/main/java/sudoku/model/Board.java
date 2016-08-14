package sudoku.model;

import java.util.Arrays;

/**
 * Created by Ninyo on 10/01/2016.
 */
public class Board {

    private int size;
    private int blockSize;
    private int[][] matrix;

    final public static int EMPTY_CELL = 0;

    public Board(int size) {
        this.matrix = new int[size][size];
        this.size = size;
        this.blockSize = (int) Math.sqrt(this.size);
    }

    public Board(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
        this.blockSize = (int) Math.sqrt(this.size);
    }

    public Board(Board board) {
        this.size = board.getMatrix().length;
        this.blockSize = (int) Math.sqrt(this.size);
        this.matrix = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            this.matrix[i] = Arrays.copyOf(board.getMatrix()[i], board.getMatrix()[i].length);
        }
    }

    public int getSize() {
        return size;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getCell(int row, int col) {
        return matrix[row][col];
    }

    public void setCell(int num, int row, int col) {
        matrix[row][col] = num;
    }

    public void print() {
        for ( int row = 0; row < this.size; row++ ) {
            for ( int col = 0; col < this.size; col++ ) {
                System.out.print(this.matrix[row][col] + " ");
                if ( col == this.blockSize - 1 || col == 2*this.blockSize - 1 ) {
                    System.out.print("  ");
                }
            }
            System.out.println();
            if ( row == this.blockSize - 1 || row == 2*this.blockSize - 1 || row == 3*this.blockSize - 1 ) {
                System.out.println();
            }
        }
    }
}