package algorithm.basic_ps.string_array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {

        //int[] digits = {1, 2, 3};
        //int[] digits = {9, 9, 9};
        //int[] digits = {0, 0, 1};
        int[] digits = {8, 9, 9, 9};

        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    private static int[] plusOne(int[] digits) {

        int n = digits.length;

        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){ // 9가 아닌 경우, 1을 증가하고 결과를 리턴한다.
                digits[i]++;
                return digits;
            }

            digits[i] = 0; // 9인 경우에는 자리 올림이 발생하기 때문에 0으로 만들어 준다.
        }

        // 위의 과정에서 전부 9만 존재 했다면 새로운 배열을 만들어 첫번째 요소에 1을 넣어준다.
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;

    }
}
