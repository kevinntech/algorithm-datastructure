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

    int m, n;
    boolean[][] visited;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if(grid == null|| grid.length == 0 || grid[0].length == 0) // 에러 처리 (정답을 구할 수 없는 경우)
            return 0;

        int result = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if(visited[x][y])
            return;

        visited[x][y] = true;

        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(0 <= nx && nx < m && 0 <= ny && ny < n){

                if(grid[nx][ny] == '1' && visited[nx][ny] == false) {
                    dfs(grid, nx, ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
