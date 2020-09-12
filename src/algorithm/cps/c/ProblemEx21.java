package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx21 {
    public static void main(String[] args) {
        /*  4 5 6 7 0 1 2 3 9 8
            1 2 3 4 5 6 7 8 9 0 */
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int[] b = new int[N];
        char lastWinner = ' ';
        int totalScoreA = 0, totalScoreB = 0;

        for(int i=0; i<N; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++){
            b[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++){
            if(a[i] > b[i]) {
                totalScoreA += 3;
                lastWinner = 'A';
            }else if(b[i] > a[i]){
                totalScoreB += 3;
                lastWinner = 'B';
            }else{
                totalScoreA += 1;
                totalScoreB += 1;
            }
        }

        if(totalScoreA == totalScoreB){
            if(lastWinner == ' '){
                System.out.println("D");
            }
        }

        System.out.println(totalScoreA + " " + totalScoreB);
        System.out.println(lastWinner);
    }
}
