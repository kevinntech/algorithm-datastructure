package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx43 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lt = 1, rt = 0 , mid, result = 0, max=-2147000000; // lt는 1로 초기화 해야 됨 (1분이 최소 값이므로)
        n = sc.nextInt(); // 곡의 개수
        m = sc.nextInt(); // DVD 개수

        int[] a = new int[n+1]; // 인덱스를 1 부터 사용하기 때문

        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
            rt += a[i]; // 입력 받은 곡의 길이를 rt에 모두 더한다.
            if(a[i] > max)
                max = a[i]; // max 값을 구한다.
        }

        while(lt <= rt){ // lt가 rt 보다 작거나 같을 떄까지 (즉, 엇갈리기 전까지는 반복)
            mid = (lt + rt) / 2; // 여기서는 mid가 DVD 한 개의 최소 용량을 의미한다.

            // mid (우리가 정한 정답)이 입력 받은 곡의 길이의 최대 값 보단 커야 됨 (반례를 수정하기 위함)
            if(mid >= max && dvdCount(a, mid) <= m){  // DVD 한 개의 최소 용량인 mid가 정답이 되니? (m 보다 작은지 확인)
                result = mid; // 답이 되므로 정답을 저장
                rt = mid - 1; // 정답인 mid 보다 큰 것들은 볼 필요가 없으므로 rt는 mid-1을 한다.
            }else{  // 정답이 불가능 하다면 큰 쪽에 답이 있다.
                lt = mid + 1;
            }
        }

        System.out.println(result);

    }

    // DVD 한 개의 최소 용량인 size로 모든 곡을 전부 녹화하는데 필요한 DVD 개수를 리턴함
    private static int dvdCount(int[] a, int size){ // size: DVD 한 개의 최소 용량
        int cnt = 1, sum = 0; // cnt는 1로 초기화한다. 처음 녹화할 떄 1개는 필요하므로

        for(int i = 1; i <= n; i++){ // 1번 곡 부터 마지막 곡까지 반복
            if(sum + a[i] > size){ // 곡의 길이를 누적하다가 size 보다 커지면 이 곡은 안되므로
                cnt++;             // DVD 개수는 하나 증가시키고
                sum = a[i];        // 새로운 DVD에 그 곡을 저장
            }else{  // size를 넘지 않으면 녹화 할 수 있으니 누적한다.
                sum += a[i];
            }
        }

        return cnt; // 모든 곡을 전부 녹화 하는데 필요한 DVD 개수를 리턴
    }
}
