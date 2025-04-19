//Time Complexity: O(N) where N is the number of pixels in the image
//Space Complexity: O(N) for the recursion stack in the worst case, where all pixels are connected
//LeetCode: https://leetcode.com/problems/flood-fill/


public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];

        if(startingColor == color) {
            return image;
        }

        dfs(image, sr, sc, startingColor, color);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int startingColor, int newColor) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || startingColor != image[row][col]) {
            return;
        }

        image[row][col] = newColor; 

        dfs(image, row+1, col, startingColor, newColor);
        dfs(image, row-1, col, startingColor, newColor);
        dfs(image, row, col+1, startingColor, newColor);
        dfs(image, row, col-1, startingColor, newColor);
    }
}
