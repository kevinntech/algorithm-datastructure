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

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int x, int y, int area) {
        visited[x][y] = true;
        area++;

        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(0 <= nx && nx < m && 0 <= ny && ny < n){
                if(grid[nx][ny] == 1 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    area = dfs(grid, nx, ny, area);
                }
            }
        }

        return area;
    }

}
