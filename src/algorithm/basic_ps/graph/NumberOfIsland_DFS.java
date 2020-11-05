package algorithm.basic_ps.graph;

public class NumberOfIsland_DFS {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIsland_DFS a = new NumberOfIsland_DFS();
        System.out.println(a.numIslands(grid));
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] group;
    int n, m;

    public int numIslands(char[][] grid) {
        if(grid == null|| grid.length == 0 || grid[0].length == 0) // 에러 처리 (정답을 구할 수 없는 경우)
            return 0;

        n = grid.length;
        m = grid[0].length;

        group = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && group[i][j] == 0) {
                    dfs(grid, i, j, ++count);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y, int count) {
        group[x][y] = count;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (grid[nx][ny] == '1' && group[nx][ny] == 0) {
                    dfs(grid, nx, ny, count);
                }
            }
        }
    }

}
