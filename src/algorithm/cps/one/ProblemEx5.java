package algorithm.cps.one;

import java.util.Scanner;

public class ProblemEx5 {
    public static void main(String[] args) {
        int year, age;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char ch = str.charAt(7);

        // 문자형 숫자('7')를 정수형 숫자로 변경하는 방법은 문자형 숫자에서 문자 '0'을 빼면 된다.
        if(ch == '1' || ch == '2'){
            year = 1900 + (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        }else{
            year = 2000 + (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        }

        age = 2020 - year + 1; // 2019년 기준 나이
        System.out.print(age + " ");

        if(ch == '1' || ch == '3'){
            System.out.println("M");
        }else{
            System.out.println("W");
        }
    }
}

/*

public class ProblemEx5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String gender = "";
        String birthYear = "";
        int age = 0;
        char gubun = ' ';

        for(int i=0; i<str.length(); i++){
            if(i == 0 || i == 1)
                birthYear += str.charAt(i);

            if(i == 7){
                gubun = str.charAt(i);
            }
        }

        if(gubun == '1' || gubun == '2')
            age =  1900 + Integer.parseInt(birthYear);
        else
            age =  2000 + Integer.parseInt(birthYear);

        if(gubun == '1' || gubun == '3')
            gender = "M";
        else
            gender = "W";

        System.out.println((2019 - age + 1) + " " + gender);
    }
}


 */