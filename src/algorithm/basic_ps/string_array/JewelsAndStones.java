package algorithm.basic_ps.string_array;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        // 1) HashSet에 보석의 각 문자를 담는다.
        Set<Character> set = new HashSet<>(); // Set은 중복을 허용하지 않는다.

        for (char jewel : J.toCharArray()) {
            set.add(jewel); // a, A
        }

        // 2) 스톤에 보석이 몇 개가 있는지 체크한다.
        int count = 0;
        for (char stoneChar : S.toCharArray()) {
            if (set.contains(stoneChar)){ // 스톤에 있는 각 문자가 HashSet에 포함 되어 있는 문자이면 보석이므로 개수를 증가시킨다.
                count++;
            }
        }

        return count;
    }

}