package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

class MyGraph{

    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    MyGraph(int size){
        nodes = new Node[size];

        for(int i = 0; i < size; i++){
            nodes[i] = new Node(i); // 0 ~ 개수-1
        }
    }

    // 간선 추가
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2))
            n1.adjacent.add(n2);

        if(!n2.adjacent.contains(n1))
            n2.adjacent.add(n1);
    }

    // dfs()를 그냥 호출하면 0번 부터 시작
    void dfs(){
        dfs(0);
    }

    void dfs(int index){
        Node r = nodes[index];
        dfs(r);
    }

    void dfs(Node r){
        if(r == null) return;
        r.marked = true;

        visit(r);
        for(Node n : r.adjacent){
            if(n.marked == false){
                dfs(n);
            }
        }
    }

    void bfs(){
        bfs(0);
    }

    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        root.marked = true;

        while(!queue.isEmpty()){
            Node r = queue.poll();

            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    queue.offer(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n){
        System.out.print(n.data + " ");
    }
}

public class MyGraphTest {
    public static void main(String[] args) {
        MyGraph graphDFS = new MyGraph(9);

        graphDFS.addEdge(0, 1); graphDFS.addEdge(1, 2); graphDFS.addEdge(1, 3);
        graphDFS.addEdge(2, 4); graphDFS.addEdge(2, 3); graphDFS.addEdge(3, 4);
        graphDFS.addEdge(3, 5); graphDFS.addEdge(5, 6); graphDFS.addEdge(5, 7);
        graphDFS.addEdge(6, 8);

        MyGraph graphBFS = new MyGraph(9);

        graphBFS.addEdge(0, 1); graphBFS.addEdge(1, 2); graphBFS.addEdge(1, 3);
        graphBFS.addEdge(2, 4); graphBFS.addEdge(2, 3); graphBFS.addEdge(3, 4);
        graphBFS.addEdge(3, 5); graphBFS.addEdge(5, 6); graphBFS.addEdge(5, 7);
        graphBFS.addEdge(6, 8);

        System.out.println("===== DFS =====");
        graphDFS.bfs();
        System.out.println();
        System.out.println("===============");
        System.out.println();

        System.out.println("===== BFS =====");
        graphBFS.bfs();
        System.out.println();
        System.out.println("===============");
        System.out.println();


    }
}
