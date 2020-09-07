package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        // 배열 a와 b의 요소를 하나씩 처음 부터 비교한다.
        for(int i=0; i<n; i++){
            if(a[i] == b[i]){                           // 비기는 경우
                System.out.println("D"); // DRAW (D)
            }else if(a[i] == 1 && b[i] == 3) {          // A가 이기는 경우에 대해서만 생각한다.
                System.out.println("A");
            }else if(a[i] == 2 && b[i] == 1) {
                System.out.println("A");
            }else if(a[i] == 3 && b[i] == 2) {
                System.out.println("A");
            }else{                                      // 그러면 나머지는 B가 이기는 경우이다.
                System.out.println("B");
            }
        }

    }
}

/*

// 내가 짠 코드
public class ProblemEx20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        // 배열 a와 b를 처음 부터 하나씩 비교하여
        for(int i=0; i<n; i++){
            if(a[i] == b[i]){
                System.out.println("D"); // DRAW (D)
            }else{
                if(a[i] == 1){
                    if (b[i] == 2){
                        System.out.println("B");
                    }else{
                        System.out.println("A");
                    }
                } else if(a[i] == 2){
                    if (b[i] == 3){
                        System.out.println("B");
                    }else{
                        System.out.println("A");
                    }
                } else {
                    if (b[i] == 1){
                        System.out.println("B");
                    }else{
                        System.out.println("A");
                    }
                }
            }
        }

    }
}

*/
