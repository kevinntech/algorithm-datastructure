package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = String.valueOf(n);
        int[] cnt = new int[10];

        int maxCnt = -2147000000;
        int maxNum = 0;

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            cnt[num]++;
        }

        for(int i=0; i<10; i++){
            if(cnt[i] >= maxCnt) {
                maxCnt = cnt[i];
                maxNum = i;
            }
        }

        System.out.println(maxNum);

    }
}


/*
    // 처음 제출 했던 답

    public class ProblemEx13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = String.valueOf(n);
        int[] cnt = new int[10];

        int maxCnt = -2147000000;
        int maxNum = -2147000000;

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            cnt[num]++;
        }

        for(int i=0; i<10; i++){
            if(cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                maxNum = i;
            }else if (cnt[i] == maxCnt){
                if(i > maxNum)
                    maxNum = i;
            }
        }

        System.out.println(maxNum);

    }
}



*/