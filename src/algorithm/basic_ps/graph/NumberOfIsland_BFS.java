package algorithm.basic_ps.graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfIsland_BFS {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIsland_BFS a = new NumberOfIsland_BFS();
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
                    bfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            for(int[] dir : dirs){
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if(0 <= nx && nx < m && 0 <= ny && ny < n){
                    if(grid[nx][ny] == '1' && visited[nx][ny] == false) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}


