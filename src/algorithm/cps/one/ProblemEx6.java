package algorithm.cps.one;

import java.util.Scanner;

public class ProblemEx6 {
    public static void main(String[] args) {
        //g0en2Ts8eSoft
        Scanner sc = new Scanner(System.in);
        int result = 0, cnt = 0;
        char ch;

        String str = sc.nextLine();

	    /*
	        str : 0 2 8
            res = res * 10 + str[i]
            res = 0 * 10 + 0 = 0
            res = 0 * 10 + 2 = 2
            res = 2 * 10 + 8 = 8
	    */

        for(int i=0; i<str.length(); i++){ // 문자열을 탐색하면서
            ch = str.charAt(i);

            if(ch >= '0' && ch <= '9'){ // 문자형 숫자이면
                result = result * 10 + (ch - '0'); // 문자형 숫자를 정수형 숫자로 변경
            }
        }

        System.out.println(result);

        for(int i=1; i<=result; i++){
            if(result%i == 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}
