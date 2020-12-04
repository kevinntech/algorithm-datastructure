package algorithm.basic_ps.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland_BFS {

    public static void main(String[] args) {

        int[][] grid =
                {
                    {1,1,0,1,1},
                    {0,1,1,0,0},
                    {0,0,0,0,0},
                    {1,1,0,1,1},
                    {1,0,1,1,1},
                    {1,0,1,1,1} };

        MaxAreaOfIsland_BFS a = new MaxAreaOfIsland_BFS();

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
                    int area = bfs(grid, i, j, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    public int bfs(int[][] grid, int x, int y, int area) {
        Queue<Pair> queue = new LinkedList<>(); // 큐를 생성한다.
        queue.offer(new Pair(x, y)); // 큐에 시작 노드를 넣는다.
        visited[x][y] = true; // 해당 노드를 방문 처리 한다.
        area++;

        while(!queue.isEmpty()){ // 큐가 비어 있지 않은 동안 반복한다.
            Pair p = queue.poll();

            for(int[] dir : dirs){
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if(0 <= nx && nx < m && 0 <= ny && ny < n){ // 내가 이동 하려는 지점(nx, ny)가 범위를 벗어나지 않고
                    if(grid[nx][ny] == 1 && visited[nx][ny] == false){ // 땅이면서 방문 한 적이 없다면
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                        area++;
                    }
                }
            }
        }

        return area;
    }

}
