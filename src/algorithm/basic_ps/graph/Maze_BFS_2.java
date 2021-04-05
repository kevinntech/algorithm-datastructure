package algorithm.basic_ps.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_BFS_2 {

    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int[] start = {0, 4};
		int[] dest  = {4, 4};

        Maze_BFS_2 a = new Maze_BFS_2();
        System.out.println(a.hasPath(maze, start, dest));
    }

    int n, m;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        /* 1 : 벽 , 0 : 빈 공간 */
        n = maze.length;
        m = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        maze[start[0]][start[1]] = 1; // 방문 처리한 지점에 대해서는 0이 아닌 값으로 저장한다.

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 현재 지점이 목적지에 도착 했다면 true를 반환한다.
            if(curr[0] == destination[0] && curr[1] == destination[1])
                return true;

            for(int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];

                // while 문인 것에 주의하자. 벽을 만나기 전까지는 계속해서 공이 굴러간다.
                while(isValid(maze,x + dir[0], y + dir[1])) {
                    x += dir[0];
                    y += dir[1];
                }

                if(maze[x][y] == 0) {
                    maze[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }

            }
        }

        return false;
    }

    private boolean isValid(int[][] maze, int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m && maze[x][y] == 0;
    }
}
