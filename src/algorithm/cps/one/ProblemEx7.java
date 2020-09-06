package algorithm.cps.one;

import java.util.Scanner;

public class ProblemEx7 {
    public static void main(String[] args) {
        // bE auTIfu L
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine() + "\n"; // 자바에서 문자열의 끝을 표현하고 싶을 떄는 "\n"를 더한다.

        for(char ch : input.toCharArray()){
            if(ch != ' ') {
                if (ch >= 'A' && ch <= 'Z')
                    System.out.print((char)(ch + 32));
                else
                    System.out.print(ch);
            }
        }

    }
}

/*

public class ProblemEx7 {
    public static void main(String[] args) {
        // bE auTIfu L
        Scanner sc = new Scanner(System.in);
        String input;
        StringBuilder result = new StringBuilder();
        char ch;

        input = sc.nextLine().toLowerCase();

        for(int i=0; i<input.length(); i++){
            ch = input.charAt(i);

            if(ch != ' '){
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}

*/



/*
// 두 번째 방법
public class ProblemEx7 {
    public static void main(String[] args) {
        // bE auTIfu L
        Scanner sc = new Scanner(System.in);
        String input;
        StringBuilder result = new StringBuilder();

        char ch;

        input = sc.nextLine();

        for(int i=0; i<input.length(); i++){
            ch = input.charAt(i);

            if(ch != ' '){
                if(ch >= 'A' && ch <= 'Z')
                    result.append((char)(ch + 32));
                else
                    result.append(ch);
            }
        }

        System.out.println(result);
    }
}

*/
