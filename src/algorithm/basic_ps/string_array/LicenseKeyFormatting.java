package algorithm.basic_ps.string_array;


public class LicenseKeyFormatting{

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
      //  String S = "2-5g-3-J";
        int k = 4;
        System.out.println(licenseKeyFormatting(s, k));
    }

    public static String licenseKeyFormatting(String S, int K) {
        // 하이픈(-)을 빈 문자열로 대체한다.
        String str = S.replace("-", "");
        // 문자열을 대문자로 변환한다.
        str = str.toUpperCase();

        // String의 내용을 StringBuilder로 옮겨 담는다.
        StringBuilder sb = new StringBuilder(str);

        // 문자열의 길이를 구한다.
        int len = sb.toString().length();

        // i : 4 -> 8 -> 12
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i, '-'); // 즉 뒤에서 부터 4 자리 마다 하이픈을 삽입한다. (문자열 전체 길이 - i)

            /*
                 0 1 2 3 4 5 6 7 8
                "5 F 3 Z 2 e 9 w"
                "5 F 3 Z - 2 e 9 w"
            */
        }

        return sb.toString();
    }
}

