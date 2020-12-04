package datastructure.string;

/*
* 입력받은 문자열 거꾸로 출력하기
* */
public class ReverseStringEx {
    public static void main(String[] args) {
        /*
        * 첫 번째 방법
        * */
        String str = "Spring Framework";

        // 문자열을 끝에서 부터 반대로 읽어나간다.
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println();

        /*
         * 두 번째 방법
         * */
        // StringBuilder 생성
        StringBuilder sb = new StringBuilder(str);

        // reverse()를 이용하여 문자열을 거꾸로 출력한다.
        System.out.print(sb.reverse());
    }
}
