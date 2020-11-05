package algorithm.basic_ps.graph;

public class MaxAreaOfIsland_DFS {

    public static void main(String[] args) {

        int[][] grid =
                {
                    {1,1,0,1,1},
                    {0,1,1,0,0},
                    {0,0,0,0,0},
                    {1,1,0,1,1},
                    {1,0,1,1,1},
                    {1,0,1,1,1} };

        MaxAreaOfIsland_DFS a = new MaxAreaOfIsland_DFS();

        System.out.println(a.maxAreaOfIsland(grid));
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] group;
    int n, m;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        n = grid.length;
        m = grid[0].length;

        group = new int[n][m];

        int islandCnt = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && group[i][j] == 0) {
                    int area = dfs(grid, i, j, ++islandCnt, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int x, int y, int islandCnt, int area) {
        group[x][y] = islandCnt;
        area++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (grid[nx][ny] == 1 && group[nx][ny] == 0) {
                    area = dfs(grid, nx, ny, islandCnt, area);
                }
            }
        }

        return area;
    }

}
