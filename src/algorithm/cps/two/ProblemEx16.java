package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx16 {
    public static void main(String[] args) {
        /*  아나그램(Anagram) : 두 문자열이 알파벳의 나열 순서는 다르지만 그 구성이 일치하는 두 단어를 말한다.

            알파벳 대문자 : 65 ~ 90  (26개)
                         -> 65- 64를 하여 1 부터 시작 하도록 함. 즉, 범위는 1 ~ 26
            알파벳 소문자 : 97 ~ 122
                         -> 대문자의 마지막 범위가 26이므로 소문자는 27 부터 시작 될 수 있도록 70을 뺀다.
                            (97-70) ~ (122-70)이므로 범위는 27 ~ 52

            [풀이 전략] 입력으로 주어진 문자열에 대한 각 알파벳의 아스키 코드를 인덱스로 하여 사용된 알파벳 개수를
                      저장한 다음, 두 문자열의 알파벳 개수를 비교한다.
         */

        Scanner sc = new Scanner(System.in);
        int[] cnt1 = new int[60]; // 총 알파벳 문자는 52개지만 넉넉하게 길이를 60으로 생성
        int[] cnt2 = new int[60];

        char[] str = sc.nextLine().toCharArray();

        boolean isAnagram = true;

        for(int i=0; i<str.length; i++){
            if(str[i]>=65 && str[i]<=90) {
                cnt1[str[i]-64]++;
            }else
                cnt1[str[i]-70]++;
        }

        str = sc.nextLine().toCharArray();

        for(int i=0; i<str.length; i++){
            if(str[i]>=65 && str[i]<=90) {
                cnt2[str[i]-64]++;
            }else
                cnt2[str[i]-70]++;
        }

        for(int i=1; i<=52; i++){
            if(cnt1[i] != cnt2[i]) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}

/*
    // 내가 제출한 답.

public class ProblemEx16 {
    public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
    int[] cnt1 = new int[123];
    int[] cnt2 = new int[123];

    String str1 = sc.nextLine();
    String str2 = sc.nextLine();

    boolean isAnagram = true;

        for(char ch : str1.toCharArray()){
                cnt1[(int)ch]++;
                }

                for(char ch : str2.toCharArray()){
                cnt2[(int)ch]++;
                }

                for(int i=0; i<cnt1.length; i++){
        if(cnt1[i] != cnt2[i]) {
        isAnagram = false;
        break;
        }
        }

        if(isAnagram == true)
        System.out.println("YES");
        else
        System.out.println("NO");

        }
        }

*/
