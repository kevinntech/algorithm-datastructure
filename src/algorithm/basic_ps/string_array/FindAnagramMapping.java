package algorithm.basic_ps.string_array;

import java.util.Arrays;
import java.util.HashMap;

public class FindAnagramMapping {

    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        int [] result = anagramMappings(A, B);

        System.out.println(Arrays.toString(result));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];

        HashMap<Integer,Integer> map = new HashMap<>();

        // Key는 B의 값이고 Value는 B의 인덱스가 저장된 Map을 만든다.
        // (내가 찾아야 되는 정답이 저장된 HashMap을 미리 만들어 둔다.)
        for(int i = 0; i < B.length; i++){
            map.put(B[i] , i);
        }

        // Map에서 A 요소 값과 같은 키의 값(B의 인덱스)을 결과 배열에 저장한다.
        for(int i = 0; i < A.length; i++){
            result[i] = map.get(A[i]);
        }

        return result;
    }

}
