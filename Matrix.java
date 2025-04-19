//Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
// Space Complexity: O(m * n) for the queue used in BFS, in the worst case where all cells are processed.
//LeetCode: https://leetcode.com/problems/01-matrix/

/**
 * Updates each cell in the matrix with the distance to the nearest 0.
 * Uses BFS starting from all 0s and expands outward to compute minimum distances.
 * Returns the updated matrix where each cell holds the shortest distance to a 0.
 */


import java.util.*;
import java.util.LinkedList;;

public class Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0)
            return matrix;

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[] { i, j });
                } else {

                    matrix[i][j] = Integer.MAX_VALUE;

                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] currentCell = q.poll();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];

                for (int[] dir : directions) {
                    int newRow = dir[0] + currentRow;
                    int newCol = dir[1] + currentCol;

                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n
                            && matrix[currentRow][currentCol] > matrix[newRow][newCol] + 1) {
                        matrix[newRow][newCol] = matrix[currentRow][currentCol] + 1;
                        q.offer(new int[] { newRow, newCol });
                    }
                }
            }
        }
        return matrix;
    }
}
