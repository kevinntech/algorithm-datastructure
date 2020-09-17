package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, s, n, work, pos;
        s = sc.nextInt(); // 캐시의 크기
        n = sc.nextInt(); // 작업의 개수
        int[] cache = new int[s];

        for(i = 0; i < n; i++){ // 작업의 개수만큼 반복
            work = sc.nextInt();
            pos = -1;

            for(j = 0; j < s; j++) {
                if (cache[j] == work) // cache hit 이면 (work 라는 작업이 캐시에 있는 상태)
                    pos = j; // hit된 지점
            }

            if(pos == -1){ // cache miss 이면 (해야 할 작업이 캐시에 없는 상태)
                for(j = s-1; j >= 1; j--)   // 캐쉬의 끝에서 부터 1까지 반복하며 앞의 작업을 한 칸씩 뒤로 밀기
                    cache[j] = cache[j-1];
            }else{ // cache hit 이면
                for(j = pos; j >= 1; j--)   // hit 지점 부터 앞의 작업을 한 칸씩 뒤로 밀어 버린다.
                    cache[j] = cache[j-1];
            }

            cache[0] = work; // 해야 할 작업은 항상 0번째 인덱스에 저장
        }

        for(i = 0; i < s; i++)
            System.out.print(cache[i] + " ");

    }
}
