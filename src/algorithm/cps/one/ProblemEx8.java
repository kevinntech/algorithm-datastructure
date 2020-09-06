package algorithm.cps.one;

import java.util.Scanner;

public class ProblemEx8 {
    public static void main(String[] args) {
        /*
            여는 괄호를 만나면 cnt 값을 1 증가 하고 닫는 괄호를 만나면 1 감소 하는 방식으로 구현
            단, 닫는 괄호가 더 많아지면 (즉, 음수가 되면) 올바르지 않은 괄호 이므로 반복을 종료한다.

            ( ( ) ) ) (
            ( ) ( ) ( ( ) ( ) )
        */

        int cnt = 0;
        char ch;

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++){
            ch = str.charAt(i);
            if(ch == '(')
                cnt++;
            else if(ch == ')')
                cnt--;

            if(cnt < 0)
                break;
        }

        if(cnt == 0)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
