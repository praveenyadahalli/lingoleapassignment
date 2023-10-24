public class Main {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        int[][] grid2 = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};

        System.out.println(maxMoves(grid1)); // Output: 3
        System.out.println(maxMoves(grid2)); // Output: 0
    }

    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Initialize dp array with 1 for each cell in the first column.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Iterate through each cell and calculate the maximum number of moves.
        for (int col = 1; col < n; col++) {
            for (int row = 0; row < m; row++) {
                dp[row][col] = 1; // Initialize with the move to the current cell

                if (row > 0 && grid[row][col] > grid[row - 1][col - 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row - 1][col - 1] + 1);
                }

                if (grid[row][col] > grid[row][col - 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + 1);
                }

                if (row < m - 1 && grid[row][col] > grid[row + 1][col - 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row + 1][col - 1] + 1);
                }
            }
        }

        // Find the maximum value in the last column, which represents the maximum moves.
        int maxMoves = dp[0][n - 1];
        for (int i = 1; i < m; i++) {
            maxMoves = Math.max(maxMoves, dp[i][n - 1]);
        }

        return maxMoves;
    }
}
