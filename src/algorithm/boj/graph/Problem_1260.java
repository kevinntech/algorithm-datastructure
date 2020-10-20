package algorithm.boj.graph;

import java.util.*;

public class Problem_1260 {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        a = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int p = sc.nextInt();

            a[u].add(p);
            a[p].add(u);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }

        c = new boolean[n+1];
        dfs(v);
        System.out.println();

        c = new boolean[n+1];
        bfs(v);
        System.out.println();

    }

    private static void dfs(int x) {
        if(c[x]){ // 방문 한 적이 있다면 메서드 종료
            return;
        }

        c[x] = true;

        System.out.print(x + " ");

        for(int y : a[x]){ // 노드 x와 연결된 인접한 노드 중 방문하지 않은 노드를 방문 처리
            if(c[y] == false){
                dfs(y);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        c[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int x = q.poll();

            System.out.print(x + " ");

            for(int y : a[x]){
                if(c[y] == false){
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
