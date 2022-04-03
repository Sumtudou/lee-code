package main;

public class LeeCode200 {
    public static void main(String[] args) {
        LeeCode200 leeCode200 = new LeeCode200();
        char[][] grid = {
                {'0', '1', '0', '0'},
                {'1', '1', '1', '0'},
                {'0', '1', '0', '0'},
                {'1', '1', '0', '0'}
        };
        System.out.println(leeCode200.numIslands(grid));
    }

    public int maxNum = 0;
    public int numIslands(char[][] grid) {
        maxNum = 0;
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, maxRow, maxCol);
                }
            }
        }
        return maxNum;
    }

    public void dfs(char[][] grid, int currentRow, int currentCol, int maxRow, int maxCol) {
        if (currentRow < 0 || currentRow >= maxRow || currentCol < 0 || currentCol >= maxCol) {
            return;
        }
        if (grid[currentRow][currentCol] != '1') {
            return;
        }
        grid[currentRow][currentCol] = '2';
        maxNum += calScore(grid, currentRow, currentCol, maxRow, maxCol);
        dfs(grid, currentRow - 1, currentCol, maxRow, maxCol);
        dfs(grid, currentRow + 1, currentCol, maxRow, maxCol);
        dfs(grid, currentRow, currentCol - 1, maxRow, maxCol);
        dfs(grid, currentRow, currentCol + 1, maxRow, maxCol);
    }

    public int calScore(char[][] grid, int x, int y, int maxRow, int maxCol) {
        return hasScore(grid, x - 1, y, maxRow, maxCol) +
                hasScore(grid, x, y - 1, maxRow, maxCol) +
                hasScore(grid, x + 1, y, maxRow, maxCol) +
                hasScore(grid, x, y + 1, maxRow, maxCol);
    }

    public int hasScore(char[][] grid, int x, int y, int maxRow, int maxCol) {
        if (x < 0 || x >= maxRow || y < 0 || y >= maxCol) {
            return 1;
        }
        if (grid[x][y] == '0') {
            return 1;
        }
        return 0;
    }

}
