class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // int[][] grid = new int[m][n];
        
        // // Mark walls as 1 and guards as 2
        // for (int[] w : walls) grid[w[0]][w[1]] = 1;
        // for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // int unguardedCount = 0;

        // // Check each cell
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         // Skip wall or guard
        //         if (grid[i][j] != 0) continue;

        //         boolean guarded = false;

        //         // check upward
        //         for (int r = i - 1; r >= 0; r--) {
        //             if (grid[r][j] == 1) break; // wall blocks view
        //             if (grid[r][j] == 2) {
        //                 guarded = true;
        //                 break;
        //             }
        //         }

        //         // check downward
        //         if (!guarded) {
        //             for (int r = i + 1; r < m; r++) {
        //                 if (grid[r][j] == 1) break;
        //                 if (grid[r][j] == 2) {
        //                     guarded = true;
        //                     break;
        //                 }
        //             }
        //         }

        //         // check left
        //         if (!guarded) {
        //             for (int c = j - 1; c >= 0; c--) {
        //                 if (grid[i][c] == 1) break;
        //                 if (grid[i][c] == 2) {
        //                     guarded = true;
        //                     break;
        //                 }
        //             }
        //         }

        //         // check right
        //         if (!guarded) {
        //             for (int c = j + 1; c < n; c++) {
        //                 if (grid[i][c] == 1) break;
        //                 if (grid[i][c] == 2) {
        //                     guarded = true;
        //                     break;
        //                 }
        //             }
        //         }

        //         // if still not guarded → count it
        //         if (!guarded) unguardedCount++;
        //     }
        // }

        // return unguardedCount;

           int[][] grid = new int[m][n];

        // 1 = wall, 2 = guard
        for (int[] w : walls) grid[w[0]][w[1]] = 1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // Directions: up, down, left, right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // For each guard → spread vision
        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Keep moving in one direction until blocked
                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == 1 || grid[nr][nc] == 2) break; // wall or guard stops vision
                    if (grid[nr][nc] == 0) grid[nr][nc] = 3; // mark guarded
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        // Count remaining unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) unguarded++;
            }
        }

        return unguarded;
        
    }
}