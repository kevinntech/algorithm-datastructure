package algorithm.basic_ps.string_array;

import java.util.*;

public class FindAllAnagrams {

    public static void main(String args[]){
        FindAllAnagrams a = new FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        System.out.println(a.findAnagrams(txt, pat));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // 에러 처리
        if(s == null || s.length() == 0 || p == null || p.length() == 0|| s.length() < p.length())
            return result;

        // 확장 아스키 코드는 8 비트이므로 256 크기의 배열을 만든다.
        int[] patternArr = new int[256];  // pattern에서 사용된 아스키코드를 기록하는 배열을 만든다.
                                         // 인덱스는 아스키 코드 값이며 배열 요소의 값은 사용 했으면 1을 저장.

        // 찾고자 하는 패턴의 아스키 코드 값을 인덱스로 하여 배열에 1로 기록한다.
        for(int i = 0; i < p.length(); i++) {
            patternArr[p.charAt(i)]++;
        }

        // compareIdx 까지만 비교하면 된다. 예시를 보면 6까지만 비교하면 된다.
        int compareIdx = s.length() - p.length() + 1;
        for(int i = 0; i < compareIdx; i++) {
            // 입력으로 주어진 문자열(s)에서 사용된 아스키코드를 기록하는 배열을 만든다.
            int[] charArr = new int[256];

            // 입력으로 주어진 문자열(s)에 대해 0번 부터 시작하여 pattern의 길이 만큼 아스키코드 사용 여부를 기록한다.
            for(int j = 0; j < p.length(); j++) {
                charArr[s.charAt(i + j)]++;
            }

            // 아나그램이면 인덱스를 정답에 추가한다.
            if(isAnagram(patternArr, charArr)) {
                result.add(i);
            }
        }

        return result;
    }

    // 주어진 두 배열이 아나그램인지 확인한다.
    private boolean isAnagram(int[] patternArr, int[] charArr) {
        for(int i = 0; i < patternArr.length; i++) {
            if(patternArr[i] != charArr[i]) { // 다르다면 아나그램이 아니다.
                return false;
            }
        }
        return true;
    }

}