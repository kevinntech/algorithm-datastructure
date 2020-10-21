package algorithm.basic_ps.string_array;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String args[]) {

        int[] nums = { 0, 1, 0, 3, 12 };

        moveZeros(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros(int[] nums) {
        int curruntPos = 0;

        // 0이 아닌 요소를 먼저 배열에 담는다.
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                nums[curruntPos++] = nums[i];
        }

        // 현재 인덱스 부터는 0으로 채운다.
        while(curruntPos < nums.length){
            nums[curruntPos] = 0;
            curruntPos++;
        }
    }
}
