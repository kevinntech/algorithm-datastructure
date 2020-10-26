package algorithm.basic_ps.string_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        int[][] result = solve(points, k);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] solve(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(new Ascending());
        //Queue<int[]> queue = new PriorityQueue<>(points.length, new Ascending());
        //Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

        int[][] result = new int[k][2];

        for(int[] p : points){ // 2차원 배열에 저장된 1차원 배열을 하나씩 꺼내 담는다.
            queue.offer(p); // 그리고 그 1차원 배열을 최소 힙에 저장한다.
        }

        int index = 0;

        // K개 만큼 2차원 정답 배열에 담는다.
        while (index < k){
            result[index] = queue.poll();
            index++;
        }

        return result;
    }
}

class Ascending implements Comparator<int[]>{

    @Override
    public int compare(int[] a, int[] b) {
        // 입력으로 주어진 2차원 배열에 저장된 각 1차원 배열에 대한 "두 점 사이의 거리"를 기준으로 최소 힙을 구성한다.
        return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]); // 원점을 기준으로 계산하므로 제곱만 하면 됨
    }
}