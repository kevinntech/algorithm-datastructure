package algorithm.cps.d;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx44 {
    static int n, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lt = 1, rt = 0 , mid, result = 0, max=-2147000000; // lt는 1로 초기화
        n = sc.nextInt(); // 마굿간의 개수
        c = sc.nextInt(); // 말의 수

        int[] x = new int[n+1]; // 마굿간의 좌표를 저장

        for(int i = 1; i <= n; i++){
            x[i] = sc.nextInt();
        }

        Arrays.sort(x);

        rt = x[n]; // 마굿간의 마지막 좌표를 저장

        while(lt <= rt){
            mid = (lt + rt) / 2;

            if(horseCount(x, mid) >= c){ // 배치한 말의 수가 조건으로 주어진 배치 해야 되는 말의 수 보다 크거나 같다면
                result = mid;   // 정답이 될 수 있으므로 정답을 갱신
                lt = mid + 1;   // 중간 값이 정답이 될 수 있다는 것은 중간 보다 큰 쪽에 정답이 또 있을 수 있다.
            }else{
                rt = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static int horseCount(int[] x, int distance){
        int cnt = 1, pos = x[1]; // cnt를 1로 초기화 하는 이유는 1마리 말을 첫 번째 좌표에 무조건 배치하기 때문

        for(int i = 2; i <= n; i++){ // 2 번째 좌표 부터 확인한다.
            if(x[i] - pos >= distance){ // i번째 좌표에서 마지막으로 말이 배치된 위치(pos)를 뺀 값이
                                        // 우리가 정한 답(distance) 보다 크거나 같다면 x[i] 좌표의 마굿간에 말을 배치 할 수 있다.
                cnt++;      // 배치한 말의 수를 증가한다.
                pos = x[i]; // 마지막으로 말이 배치된 위치를 갱신함
            } // 배치 할 수 없다면 다음 반복으로 넘어감
        }

        return cnt;
    }
}
