package datastructure.graph;

import java.util.*;

public class DFS_BFS {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void dfs(int x) {
        if (visited[x]) // 방문 처리를 했다면 메서드 종료
            return;

        visited[x] = true; // 방문 처리를 합니다.
        System.out.print(x + " ");  // 방문 처리한 노드를 출력 합니다.

        for (int y : adj[x]) {    // 노드 x와 연결된 인접한 노드 중 방문 하지 않은 노드를 방문 합니다.
            if (visited[y] == false)
                dfs(y);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();   // 큐를 생성 합니다.
        visited[start] = true;    // 노드를 방문 처리 합니다.
        queue.offer(start);       // 큐에 노드를 추가 합니다.

        while (!queue.isEmpty()) {  // 큐가 비어 있지 않은 동안 반복 합니다.
            int x = queue.poll(); // 큐에서 하나의 노드를 꺼냅니다.
            System.out.print(x + " "); // 꺼낸 노드를 출력 합니다.

            for (int y : adj[x]) {    // 방금 꺼낸 노드와 연결된 노드 중 방문하지 않은 노드가 있다면 방문 처리를 하고 큐에 넣어줍니다.
                if (visited[y] == false) {
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        adj = (ArrayList<Integer>[]) new ArrayList[n + 1];

        for (int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(adj[i]);  // 인접 리스트를 정렬한다. (방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하기 위해서)
        }

        visited = new boolean[n+1];
        dfs(start);
        System.out.println();

        visited = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}
