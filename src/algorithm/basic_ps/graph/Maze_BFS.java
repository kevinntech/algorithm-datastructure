package algorithm.basic_ps.graph;

import java.util.*;

public class Maze_BFS {

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

        Maze_BFS a = new Maze_BFS();
        System.out.println(a.hasPath(maze, start, dest));
        a.print(a.visited);
    }

    int n, m;
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        /*
            1 : 벽 , 0 : 빈 공간
        */
        n = maze.length;
        m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;

            for(int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];

                // while 문인 것에 주의하자. 벽을 만나기 전까지는 계속해서 공이 굴러간다.
                while(isValid(maze, x + dir[0], y + dir[1])) {
                    x += dir[0];
                    y += dir[1];
                }

                if(!visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }

            }
        }

        return false;
    }

    private boolean isValid(int[][] maze, int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m && maze[x][y] == 0;
    }

    private void print(boolean[][] visited) {
        if(visited == null|| visited.length == 0) return;

        System.out.println();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
