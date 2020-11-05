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
                    int area = bfs(grid, i, j, ++islandCnt, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    public int bfs(int[][] map, int x, int y, int islandCnt, int area) {
        Queue<Pair> q = new LinkedList<>();		// 큐를 생성한다.
        q.add(new Pair(x, y));				        // 큐에 시작 노드를 넣는다.
        group[x][y] = islandCnt;				        // 해당 노드를 방문 처리 한다. 이때, 섬의 개수(cnt)로 저장한다.
        area++;

        while (!q.isEmpty()) {				        // 큐가 비어 있지 않은 동안 반복한다.
            Pair p = q.remove();
            x = p.x;
            y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {      // 내가 이동 하려는 지점(nx, ny)가 범위를 벗어나지 않고
                    if (map[nx][ny] == 1 && group[nx][ny] == 0) {  // 땅이면서 방문 한 적이 없다면
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = islandCnt;
                        area++;
                    }
                }
            }
        }

        return area;
    }

}
