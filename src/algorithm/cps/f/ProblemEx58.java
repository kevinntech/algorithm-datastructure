package algorithm.cps.f;

public class ProblemEx58 {
    public static void main(String[] args) {
        // 부모 노드, 자식 노드
        DFS(1);
    }

    private static void DFS(int v) {
        if(v > 7) { // 종료 지점
            return;
        }else{
            System.out.print(v + " "); // 전위 순회
            DFS(v*2); // 왼쪽 자식 노드
            //System.out.print(v + " "); // 중위 순회
            DFS(v*2+1); // 오른쪽 자식 노드
            //System.out.print(v + " "); // 후위 순회 (왼쪽 자식, 오른쪽 자식의 일이 다 끝나고 자기 자신의 할 일 하는 것)
        }

    }
}
