package algorithm.cps.e;

import java.util.Scanner;

public class ProblemEx46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] work = new int[n + 1];
        int totalTime = 0 , k , num = 0 , seconds = 0; // num : 작업번호

        for(int i = 1; i <= n; i++){
            work[i] = sc.nextInt();
            totalTime += work[i];
        }

        k = sc.nextInt();   // 정전 시간

        if(k >= totalTime){ // 정전 시간이 전체 시간 보다 크거나 같으면
            System.out.println("-1"); // 정전 되기 전에 끝난 것이므로
            System.exit(0);
        }

        while(true){
            num++;

            if(num > n)
                num = 1; // 1번 작업으로 돌아감

            if(work[num] == 0)
                continue; // 다음 반복으로 넘어감 , 작업 시간이 0이면 시간 초를 세지 않음

            work[num]--;
            seconds++;

            if(seconds == k)
                break;
        }

        // 정전 된 다음, 전기가 다시 들어 왔을 때
        while(true){
            num++;

            if(num > n)
                num = 1; // 1번 작업으로 돌아감

            if(work[num] != 0)
                break;
        }

        System.out.println(num);

    }
}
