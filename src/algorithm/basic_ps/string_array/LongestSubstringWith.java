package algorithm.basic_ps.string_array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith {

    public static void main(String[] args) {
        String s = "ccaabbb";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    // 주어진 문자열(s)에서 서로 다른 문자 2개를 사용 했을 때 만들 수 있는 최대 길이를 구한다.
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // Map, 투 포인터
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, len = 0, count = 0; // start는 시작점, end는 끝점, count는 문자 개수를 의미하며 문자 2개를 사용 했는지를 체크할 때 사용

        /*
        * getOrDefault() : 지정된 키의 값을 반환한다. 만약 없다면 기본 값을 반환한다.
        * */
        while(end < s.length()){
            char endChar = s.charAt(end); // 끝점(end)이 가리키는 문자
            map.put(endChar, map.getOrDefault(endChar, 0) + 1); // Map에 알파벳 별 사용한 문자 개수를 기록한다.

            if(map.get(endChar) == 1) { // 해당 문자가 map에 저장된 개수가 1이면 새로운 문자가 나타난 것을 의미
                count++;                // 문자 개수(count)를 증가 시킨다.
            }
            end++;  // 끝점을 한 칸 뒤로 옮긴다.

            // 앞서 사용 했던 문자(c) 2개를 삭제한다.
            while(count > 2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1); // map에서 시작점(start)이 가리키는 문자와 같은 문자 개수를 감소시킨다.

                if(map.get(startChar) == 0) // 해당 문자가 map에 저장된 개수가 0이면 완전히 제거 된 것이므로 문자 개수를 감소시킨다.
                    count--;

                start++;
            }

            len = Math.max(len, end-start);  // 정답은 end = 7, start가 2 일 때,
        }

        return len;
    }
}
