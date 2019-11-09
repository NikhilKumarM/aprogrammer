package com.nikhil.aprogrammer.array;

import java.util.Arrays;

/**
 * Implementing a program to find the Unique paths in 2D matrix from left most corner to right most corner.
 * Matrix can have values 0 ,1. 0 means location is empty and 1 means location is blocked.
 * <p>
 * We can only move either right or down of the location in the matrix.
 *
 * @author Nikhil Kumar Mengani
 */
public class UniquePaths {

    /**
     * This method is to find the total number of paths from left most corner of matrix to right most corner.
     *
     * @param obstacleGrid Given Matrix consisting of 0s and 1s.
     * @return Return Number of paths to go from left most corner to right most corner of matrix. Return 0 if there are
     * no paths.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        int rows = obstacleGrid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = obstacleGrid[0].length;

        // Initially storing -1 because some of the positions might have 0 paths.
        int[][] storage = new int[rows][cols];
        for (int[] row : storage) {
            Arrays.fill(row, -1);
        }

        return findUniquePaths(0, 0, rows, cols, storage, obstacleGrid);
    }

    /**
     * This is the helper method to find number of paths to go from left most corner to right most corner of matrix.
     *
     * @param i       current row in the matrix
     * @param j       current column in the matrix
     * @param rows    Number of rows in the matrix
     * @param cols    Number of columns in the matrix.
     * @param storage Cache Storage to save number of paths possible current position to right most corner of matrix.
     * @param matrix  Given Matrix consisting of 0s and 1s.
     * @return Return Number of paths to go from left most corner to right most corner of matrix. Return 0 if there are
     * no paths.
     */
    private int findUniquePaths(int i, int j, int rows, int cols, int[][] storage, int[][] matrix) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[i][j] == 1) {
            return 0;
        }

        if (storage[i][j] >= 0) {
            return storage[i][j];
        }

        if ((i == rows - 1) && (j == cols - 1)) {
            return 1;
        }

        int right = findUniquePaths(i, j + 1, rows, cols, storage, matrix);
        int down = findUniquePaths(i + 1, j, rows, cols, storage, matrix);

        storage[i][j] = right + down;
        return right + down;
    }

}
