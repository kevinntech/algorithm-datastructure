package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0, h = 0, i, pos;
        String str = sc.nextLine() + "\n"; // 자바에서 문자열의 끝을 표시하고 싶다면 "\n"를 추가

        if(str.charAt(1) == 'H') {
            c = 1;
            pos = 1;
        }else{
            for(i = 1; str.charAt(i) != 'H'; i++){
                c = c * 10 + (str.charAt(i) - '0');
            }

            pos = i; // H 가 있는 지점
        }

        if(str.charAt(pos + 1) == '\n') {
            h = 1;
        } else {
            for (i = pos + 1; str.charAt(i) != '\n'; i++) {
                h = h * 10 + (str.charAt(i) - '0');
            }
        }

        System.out.println(c * 12 + h); // 탄소(c) 한 개의 질량은 12g
    }
}
