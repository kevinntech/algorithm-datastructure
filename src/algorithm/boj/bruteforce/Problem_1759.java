package algorithm.boj.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int c = sc.nextInt();

        String[] alpha = new String[c];

        for(int i=0; i<c; i++){
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);

        go(l, alpha, "", 0);
    }

    private static void go(int l, String[] alpha, String password, int index) {

        if(password.length() == l){
            if(check(password)){
                System.out.println(password);
            }
            return;
        }

       if(index >= alpha.length)
           return;

        // 다음 경우
        go(l, alpha, password + alpha[index], index+1);
        go(l, alpha, password, index+1);
    }

    private static boolean check(String password) {
        int ja = 0;
        int mo = 0;

        for(char x : password.toCharArray()){
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                mo += 1;
            }else{
                ja += 1;
            }
        }

        return mo >= 1 && ja >= 2;
    }
}
