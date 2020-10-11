package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_3085 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        char[][] a = new char[n][n];
        int ans = -2147000000;

        for(int i=0; i<n; i++){
            a[i] = sc.next().toCharArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j+1 < n){ // 오른쪽과 교환
                    char t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;

                    int temp = check(a);

                    if(ans < temp)
                        ans = temp;

                    t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;
                }

                if(i+1 < n){ // 아래쪽과 교환
                    char t = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = t;

                    int temp = check(a);

                    if(ans < temp)
                        ans = temp;

                    t = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = t;
                }
            }
        }

        System.out.println(ans);
    }

    private static int check(char[][] a) { // 가장 긴 연속 부분 행 또는 열을 구하는 메서드
        int ans = 1;
        int n = a.length;

        for(int i=0; i<n; i++){
            int cnt = 1; // 0번 열만 있더라도 하나가 연속하는 것과 같으므로 ans, cnt 모두 1로 초기화

            for(int j=1; j<n; j++){ // 하나의 행이 얼마나 연속 되는지 찾는다.
                if(a[i][j] == a[i][j-1]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                if(ans < cnt)
                    ans = cnt;
            }

            cnt = 1; // 0번 행만 있더라도 하나가 연속하는 것과 같으므로 ans, cnt 모두 1로 초기화

            for(int j=1; j<n; j++){
                if(a[j][i] == a[j-1][i]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                if(ans < cnt)
                    ans = cnt;
            }
        }

        return ans;
    }
}
